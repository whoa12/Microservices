# Microservices
This is my first microservices project, equipped with Resillence4j. MongoDB, PostGreSQL and MySQL are used.
This microservice structure consists of Users, hotels and ratings. I have used an API gateway for managing requests easily. A user or a third party can easily access ratings of users of the respective hotels using this structure. The circuit breaking feature of Resilliance4j is also used to continue running this application if one of the services is down. 

