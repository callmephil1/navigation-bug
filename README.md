This is a minimal reproducible example of a bug i encountered using compose navigation with KMM Compose.

There are two classes. `AnotherClass` which just represents some random data.
And `Destination` which is a sealed class to be used for navigation.

Inside `Destination` there is a static function called `of` which takes in `obj: Any` and returns a destination from a private map.

When add a `NavHost` to the code the first entry in the map gets set to null for some reason. If i comment out the `NavHost` then the bug disappears.