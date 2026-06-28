# GitHub Popularity Scorer

This project was created as part of the **Redcare Backend Coding Challenge**.

It exposes a REST API that searches public GitHub repositories based on a programming language and a creation date. The retrieved repositories are ranked using a custom popularity score based on stars, forks and recent activity.

## Run

```bash
./gradlew bootRun
```

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

### Missing / Possible Improvements

* Currently only the first page (max. 100 repositories) is fetched. This can lead to inaccurate rankings because GitHub sorts by stars, while the final score also considers forks and recent activity.
* Support pagination to evaluate more repositories.
* Make the scoring weights configurable.
* Add caching to reduce GitHub API requests.
* Improve handling of GitHub rate limits and retries.
* More Tests..
