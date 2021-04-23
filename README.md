# Simple JSON Builder

SJB is a simple Java library whose purpose is to build JSON strings for unit testing purposes.

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
