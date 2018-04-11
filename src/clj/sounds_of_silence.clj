(ns sounds-of-silence
  "A clojure.test fixture"
  (:import [me.arrdem.silence NullWriter ErrorWriter]))

(defmacro with-out
  "Macro.

  Executes forms in a context with `*out*` bound to the given writer."
  [writer & forms]
  `(binding [*out* ~writer]
     ~@forms))

(defmacro with-err
  "Macro.

  Executes forms in a context with `*err*` bound to the given writer."
  [writer & forms]
  `(binding [*err* ~writer]
     ~@forms))

(defmacro with-out+err
  "Macro.

  Executes the forms in a context with `*out*` and `*err*` bound to the same (given) writer."
  [writer & forms]
  `(let [writer# ~writer]
     (binding [*out* writer#
               *err* writer#]
       ~@forms)))

(defn silence
  "clojure.test fixture.

  Wraps the given test fixture, running it with `*out*` and `*err*` fully suppressed.

  Does NOT manipulate `System/out` or `System/err`."
  [f]
  (with-out+err (NullWriter.)
    (f)))

(defn lamentation
  "clojure.test fixture.

  Runs the given tests with `*out*` and `*err*` bound to exception producing writers.

  Does NOT manipulate `System/out` or `System/err`."
  [f]
  (with-out+err (ErrorWriter.)
    (f)))
