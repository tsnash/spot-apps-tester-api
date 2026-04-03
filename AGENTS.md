# Import formatting guidelines
* Group imports as follows:
```java
package PACKAGE;

import static java.util.PACKAGE;

import static other.PACKAGE;

import static local.PACKAGE;

import java.util.PACKAGE;

import other.PACKAGE;

import local.PACKAGE;

```
* Avoid wildcard imports when less than 25 imports share the same package

# Entity guidelines
* All database entities should be added to the `model` package.
* Annotate class with `@Table` and specify the `name` parameter.
* Make sure each `@Column` and `@JoinColumn` annotation have `name` parameters specified.
* Focus on immutable fields for hashCode and equals methods.
* Columns that shouldn't be null should both be annotated with `@NotNull` and include `nullable = false` within the column annotation.
* Columns annotated with `@Id` should be the first fields in the class and when present `@MapsId` annotated colums should be right after.
* Entities on the inverse side of a bidirectional relationship should always maintain bidirectional consistency with their setter methods.

# Repository guidelines
* All database repositories should be added to the `dao` package.
* Make sure it is an interface named `<EntityName>Repository` that extends `JpaRepository`.


# Data transfer object guidelines
* All data transfer objects should be under the `dto` package. *NOTE: response dtos are in `dto.response`*
* Annotate class with appropriate `@JsonInclude`.
* Follow with a `@JsonPropertyOrder` annotation that lists the fields in the order they are declared in the class.
* Add `@JsonProperty` annotations to each field using the field name as the parameter.
* Then make sure the class and each field are annotated with `@Schema` with corresponding `description` parameters.
* Provide an `example` within the field's `@Schema` annotation if the field is simple enough (i.e. String or Integer).
* Make sure that fields annotated with `@Min` and `@Max` have the corresponding values added to the `@Schema` parameters (minimum and maximum respectively).

# Service guidelines
* All services should be added to the `service` package.
* Typically services should consist of an interface and an implementation class (suffixed with `Impl`).
* Interface should only include essential methods that are used by controllers (or other services) directly without any implementation.
* Only annotate the implementing class with `@Service`.


# Controller guidelines
* All controllers should be added to the `controller` package.
* Typically controllers should consist of an interface and an implementation class (suffixed with `Impl`).
* The interface should be annotated with a `@Tag` annotation that describes the primary service it uses.
* Both the interface and implementation classes should be annotated with `@RestController` and `@RequestMapping` that has a parameter of the base url of that endpoint.
* The interface fields should be exclusively comprised of methods that make up each API endpoint and annotated accordingly:
```java
@Operation(summary = "", description = "", tags = {""})
@ApiResponses({
    @ApiResponse(responseCode = "", description = "", content = { @Content(mediaType = "", schema = @Schema(implementation = "")) }),
    @ApiResponse(responseCode = "", description = "", content = { @Content(mediaType = "", schema = @Schema(implementation = "")) })
})
// Choose the appropriate shortcut method here
@GetMapping(produces = {})
@PostMapping(consumes = {}, produces = {})
@PutMapping(consumes = {}, produces = {})
@DeleteMapping(produces = {})
```
* The implementation fields that override the interface methods only need to include the matching shortcut method annotation.
* Make sure that the annotations within the API method signatures match as well.


# Exception guidelines
* All exceptions should be added to the `exception` package.
* There should only be two types of exceptions defined here.
  * A base exception that extends `RuntimeException` that is named after an HTTP response code with a generic message. It must be handled in the `GlobalExceptionHandler` class.
  * A custom exception that should only extend one of the aforementioned base exception classes. Its name and message should better reflect the specific problem that occurred.