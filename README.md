### Needed files/directories

* Chrome driver in `src/main/resources`. System is detected automatically, no need to add/remove `.exe` extension.
* `environment.yaml` in `src/main/resources`. Example settings below</br>
    ```yaml
    language: pl    #Language set in LocalStorage
    headless: true  #Should WebDriver run headless browser 
    timeout: 25     #FluentWait base timeout
    envs:
      production:
        url: https://link-to-production.com/ 
        env: PRODUCTION
        active: false
      test:
        url: https://link-to-tests.com/
        env: TEST
        active: true  #only one env can be active, errors will probably occur otherwise
    ```
* `Download` directory in `src/test/resources`

#### Optional

* JUnit properties for parallel testing.</br>
  `junit-platform.properties` in `src/test/resources`</br>
    ```properties
    junit.jupiter.execution.parallel.enabled = true
    junit.jupiter.execution.parallel.mode.default = same_thread
    junit.jupiter.execution.parallel.mode.classes.default = concurrent
    junit.jupiter.execution.parallel.config.strategy = fixed
    junit.jupiter.execution.parallel.config.fixed.parallelism = 3
    ```

### Tests

Run tests with

```shell
mvn clean test
```

or for report in .html (report will be located in ```target/site```)

```shell
mvn clean surefire-report:report
```