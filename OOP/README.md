Question 4:
1. Create new Entity (Branch) contains isolate data for (Order, OrderItem, Product, Transaction, Coupon, customer level, discount event) by itself.
- Move code in Main file to Branch class
- In main.java, the job is navigating between branch only

2. Add them to queue, using tools like Kafka to notify for email service when have new requests and also store these requests until it finishes, if the app crash, it has strategy to trigger these events haven't sent yet.