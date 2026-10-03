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