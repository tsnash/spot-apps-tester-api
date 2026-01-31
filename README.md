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

- To enable encryption at rest, you must set the `ENCRYPTION_KEY` environment variable. This should be a Base64-encoded 256-bit key. You can generate one with the following command:
  ```bash
  python3 -c "import os, base64; print(base64.b64encode(os.urandom(32)).decode('utf-8'))"
  ```
  Then, export the key:
  ```bash
  export ENCRYPTION_KEY=<your-generated-key>
  ```

## Docker Notes
- build image from project root
```bash
docker build -t tester:latest .
```
- run container
```bash
docker run -p 8080:8080 -e ENCRYPTION_KEY=<your-generated-key> tester:latest
```

## Render Notes
- While in the dashboard of the API make sure to navigate to `Manage -> Environment -> Environment Variables` and assign a `SPRING_PROFILES_ACTIVE` key to the value `render`

- Get the appropriate `postgresql` url from your database dashboard via `Info -> Connections -> Internal/External Database URL` and assign a `SPRING_DATASOURCE_URL` key to the value of the url

## Roadmap
- Rework and standardize repositories and their tests

- Centralize user IDs to a common database entity and have profiles use a foreign key instead

- Implement remaining properties for `UserProfile` related entities

- Consider and address PII concerns including but not limited to
  - Encryption at rest for sensitive data
    - **Note on Encryption Key Management:** The encryption key is sourced from the `ENCRYPTION_KEY` environment variable. For production environments, it is highly recommended to use a secure key management service such as AWS KMS or HashiCorp Vault.
  - Proper audit logging for data access
  - Compliance with GDPR/CCPA requirements
  - Data retention and deletion policies
  - Appropriate masking in logs and error messages

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

