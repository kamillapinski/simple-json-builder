# Simple JSON Builder

[![](https://jitpack.io/v/kamillapinski/simple-json-builder.svg)](https://jitpack.io/#kamillapinski/simple-json-builder)

SJB is a simple Java library whose purpose is to build JSON strings for unit testing purposes.
It is licensed under the MIT license - check [LICENSE.md](./LICENSE.md).

## Using SJB

You can download the artifacts from JitPack. Maven example:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
```xml
<dependency>
    <groupId>com.github.kamillapinski</groupId>
    <artifactId>simple-json-builder</artifactId>
    <version>VERSION</version>
</dependency>
```

## Example
```java
import com.kamillapinski.sjb.api.JsonObject;
import static com.kamillapinski.sjb.api.Json.*;

...

JsonObject userObject = object(
    field("firstName", "Joe"),
    field("lastName", "Doe"),
    field("communicationChannels", array(
        object(
            field("type", "email"),
            field("value", "joe.doe@gmail.com")
        ),
        object(
            field("type", "phone"),
            field("value", "+01111222333")
        )
    )),
    nullField("birthDate")
);

String json = userObject.asString(); // .toString() works too!
System.out.println(json);
```

Output:
```json
{
    "firstName": "Joe",
    "lastName": "Doe",
    "communicationChannels": [
        {
            "type": "email",
            "value": "joe.doe@gmail.com"
        },
        {
            "type": "phone",
            "value": "01111222333"
        }
    ],
    "birthDate": null
}
```
