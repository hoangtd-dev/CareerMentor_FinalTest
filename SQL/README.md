QUESTION 1.1
```
WITH tb_duplicate_email AS (
    SELECT email, COUNT(*) OVER (PARTITION BY email) duplicate_count
    FROM users
)
SELECT DISTINCT email 
FROM tb_duplicate_email WHERE duplicate_count > 1;
```

QUESTION 1.2
```
WITH tb_duplicate_email AS (
    SELECT email, id, COUNT(*) OVER (PARTITION BY email) duplicate_count, RANK() OVER (PARTITION BY email ORDER BY id) ranking
    FROM users
)
DELETE u FROM users u JOIN tb_duplicate_email tb ON tb.id = u.id WHERE duplicate_count > 1 AND ranking > 1;
```

QUESTION 2
```
```

# SYSTEM DESIGN
### QUESTION 2:
Define with these steps below:
- hotels:
	+ id is primary key

- room_types:
	+ id is primary key

- rooms:
	+ id is primary key
	+ ensure creating a constraint (room_type_id) to ref to room_types.id
	+ add index for capacity (Room rarely changes and user need to search with capacity frequently)

- booking_details:
	+ reservation_id + room_id is composite key
	+ ensure creating a constraint (room_id) to ref to rooms.id and (reservation_id) to ref to reservations.id
	+ add index for check_in_date and check_out_date (booking_details rarely changes and user need to search with capacity frequently)

- reservations:
	+ id is primary key

- customers:
	+ id is primary key

- reviews:
	+ customer_id + hotel_id is composite key
	+ ensure creating a constraint (customer_id) to ref to customers.id and (hotel_id) to ref to hotels.id

These setups will lead to reduce time to logn when search with key or index column

### QUESTION 3:
- Investigate the time in day has minimum traffic like mid night to UPDATE data, it will not effect user experience
- Update by trunk of data instead of 100 millions in 1 transactions, separate to small trunk like 100 thousands per transactions, so we can rollback if there is any error
- Ensure update log to investigate error

### QUESTION 4:
For the database, we can lock the row to ensure only 1 updated request at the same time
For the app, in frontend, we can ignore to click the same button during 500ms, ensure no mistake and bot spam.

