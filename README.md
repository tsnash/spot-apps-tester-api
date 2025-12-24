# spot-apps-tester-api
Java SpringBoot API for testing operations against various models

## Endpoint Resource Summary
| Resource         | Description                              |
| :--------------- | :--------------------------------------- |
| `/`              | Open API Swagger UI Documentation        |
| `/user-profiles` | Retrieve users and their preference info |

## Local Notes
- Project uses Java 21 SDK w/ Maven 3.9.9

- Either set `spring.profiles.active` via config or `SPRING_PROFILES_ACTIVE` via environment variable to `local`

- By default it loads an `h2` database in memory but you can specify a `postgresql` database using the corresponding `spring.datasource` properties


## Docker Notes
- build image from project root
```bash
docker build -t tester:latest .
```
- run container
```bash
docker run -p 8080:8080 tester:latest
```

## Render Notes
- While in the dashboard of the API make sure to navigate to `Manage -> Environment -> Environment Variables` and assign a `SPRING_PROFILES_ACTIVE` key to the value `render`

- Get the appropriate `postgresql` url from your database dashboard via `Info -> Connections -> Internal/External Database URL` and assign a `SPRING_DATASOURCE_URL` key to the value of the url

## Roadmap
- Correct `UserProfile` hashing and equality logic

- Centralize user IDs to a common database entity and have profiles use a foreign key instead

- Represent the remaining properties of the `UserProfile`

- Develop models, services, and controllers for `DataProfile` and `RatingProfile` along with any additional properties

- Consider emojis for commit prefixes for clarity

- Admin login (`/admin`) and additional resource management endpoints (`/admin/{resource}`)

- Implement soft deletion of database rows

- Take a look at setting up database indexes

- Decide on removing auxiliary ids from DTOs

## Demo
[Try it out on Render](https://spot-apps-tester-api.onrender.com/)

*Note:* If the API hasn't been used recently it will take some time to spin up.


## License
[GNU GPL v3.0](https://choosealicense.com/licenses/gpl-3.0/)

