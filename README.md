# The Sounds of Silence
<img align="right" src="https://github.com/arrdem/sounds-of-silence/raw/master/etc/sounds-of-silence.jpg" width=300/>

[![Clojars Project](https://img.shields.io/clojars/v/me.arrdem/sounds-of-silence.svg)](https://clojars.org/me.arrdem/sounds-of-silence)

> Hello darkness my old friend
>
> I've come to talk with you again
>
> -- Simon & Garfunkel ~ The Sounds of Silence

In keeping with the Unix philosophy, tests (and other programs) should produce
no output when they execute normally unless they are explicitly asked to.
Unfortunately, it can be difficult to track down what's writing to `*out*` and
how to go make it stop.

This library provides a pair of `clojure.test` fixtures named `silence` and
`lamentation`. `silence` as a fixture mutes all output to `*out*` and `*err*`
by simply providing a bindings to a no-op `Writer` class. `lamentation` makes
writing to `*out*` and `*err*` fatal, by throwing an `IOException` when either
output stream is written to. 

## 

```clj
(ns my.tests
  (:require [clojure.test :refer [use-fixtures is deftest]]
            [sounds-of-silence :refer [lamentation]]))

(use-fixtures :each lamentation)

(deftest my-test
  (println "This will cause an IOException!"))
```

## License

Copyright © 2017 Reid 'arrdem' McKenzie

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
