<h1 align="center">:fire: تنافسوا</h1>

![CI](https://github.com/challenge-azkar/azkar-api/workflows/CI/badge.svg?branch=master)

A Spring boot application that is a backend for a mobile application for Muslims to help them challenge and motivate themselves and their friends to read Azkar in a fun way.

[On Play Store](https://play.google.com/store/apps/details?id=com.tanafaso.azkar) & [On App Store](https://apps.apple.com/us/app/تنافسوا/id1564309117?platform=iphone)

Also, take a look at the [Frontend](https://github.com/challenge-azkar/tanafaso-frontend) repository.

| ![logo](https://user-images.githubusercontent.com/13997703/122165215-2f4e7380-ce78-11eb-91ce-391ce240321f.png) | ![Screenshot_1621806606](https://user-images.githubusercontent.com/13997703/122512358-07424a00-d009-11eb-8157-623b728dea03.jpeg) | ![Screenshot_1621806667](https://user-images.githubusercontent.com/13997703/122512360-07dae080-d009-11eb-9302-f5b096192161.jpeg) | ![Screenshot_1621806734](https://user-images.githubusercontent.com/13997703/122512364-08737700-d009-11eb-8722-b2542ed85f60.jpeg) |
|-|-|-|-|
| ![Screenshot_1622827279](https://user-images.githubusercontent.com/13997703/122512366-090c0d80-d009-11eb-98b5-97d9a21feba9.jpeg) | ![Screenshot_1622827285](https://user-images.githubusercontent.com/13997703/122512367-090c0d80-d009-11eb-98f4-8c187d30e81e.jpeg) | ![Screenshot_1623259103](https://user-images.githubusercontent.com/13997703/122512368-09a4a400-d009-11eb-9b31-f3d02aed4a0e.png) | ![Screenshot_1623334651](https://user-images.githubusercontent.com/13997703/122512371-09a4a400-d009-11eb-8406-60536604d5f7.png) |

## Code Structure
- [configs/](https://github.com/challenge-azkar/tanafaso-backend/tree/master/src/main/java/com/azkar/configs): Contains classes annotated with  [@Configuration](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Configuration.html), which means that those classes declares beans. Those beans will either be used when needed throughout the code, e.g. in [CategoriesCacher](https://github.com/challenge-azkar/tanafaso-backend/blob/master/src/main/java/com/azkar/configs/CategoriesCacher.java) or will be scanned by a library and used on startup, e.g. in [MongobeeConfig](https://github.com/challenge-azkar/tanafaso-backend/blob/master/src/main/java/com/azkar/configs/MongobeeConfig.java).
- [controllers/](https://github.com/challenge-azkar/tanafaso-backend/tree/master/src/main/java/com/azkar/controllers): Contains the logic that is applied when every kind of request is received, e.g. [FriendshipController](https://github.com/challenge-azkar/tanafaso-backend/blob/master/src/main/java/com/azkar/controllers/FriendshipController.java) contains the logic for every endpoint related to friendship, like requesting/accepting/rejecting a friendship.
- [entities/](https://github.com/challenge-azkar/tanafaso-backend/tree/master/src/main/java/com/azkar/entities): Contains the definitions of all of the models used in the application, e.g. [User](https://github.com/challenge-azkar/tanafaso-backend/blob/master/src/main/java/com/azkar/entities/User.java). 
- [payload/](https://github.com/challenge-azkar/tanafaso-backend/tree/master/src/main/java/com/azkar/payload): Contains the definition of the structure of every request and every response, e.g. [UpdateChallengeRequest](https://github.com/challenge-azkar/tanafaso-backend/blob/master/src/main/java/com/azkar/payload/challengecontroller/requests/UpdateChallengeRequest.java) and [UpdateChallengeResponse](https://github.com/challenge-azkar/tanafaso-backend/blob/master/src/main/java/com/azkar/payload/challengecontroller/responses/UpdateChallengeResponse.java).
- [repos/](https://github.com/challenge-azkar/tanafaso-backend/tree/master/src/main/java/com/azkar/repos): Contains interfaces that are all annotated by [@Repository](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Repository.html) and will be scanned on startup to create beans for every repository that can later be [@Autowired](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Autowired.html) and used throughout the code to interact with the Mongo database.
- [services/](https://github.com/challenge-azkar/tanafaso-backend/tree/master/src/main/java/com/azkar/services): Contains interfaces that are all annotated by [@Service](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Service.html) and can be used throughout the code to provide some utilities, e.g. [NotificationsService](https://github.com/challenge-azkar/tanafaso-backend/blob/master/src/main/java/com/azkar/services/NotificationsService.java) can be used to send a notification to a user.

## Contributing
(Optionally) join Tanafaso's [discord server](https://discord.gg/JQ7zYXCw) to give feedback, propose new features or ask for help.

There are a lot of ways you can contribute to this project. You can filter issues by `good first issue` label to get started with an issue that is easy to fix.
- Suggest new features by filing an issue.
- Report bugs by filing an issue.
- Add code documentation, so that it is easier for future contributers to ramp-up.
- Add tests.
- Refactor the code to make it more readable, maintainable and scalable.
- Add pull requests with bug fixes.
- Add pull requests with new features.

## License
The application code is licensed under [MIT LICENSE](https://github.com/challenge-azkar/tanafaso-backend/blob/master/LICENSE.md).
