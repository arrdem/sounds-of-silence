(ns sounds-of-silence
  "A clojure.test fixture"
  (:import [me.arrdem.silence NullWriter ErrorWriter]))

(defn silence
  "clojure.test fixture.

  Wraps the given test fixture, running it with `*out*` and `*err*` fully suppressed."
  [f]
  (let [nulwrtr (NullWriter.)]
    (binding [*out* nulwrtr
              *err* nulwrtr]
      (f))))

(defn lamentation
  "clojure.test fixture.

  Runs the given tests with `*out*` and `*err*` bound to exception producing writers."
  [f]
  (let [errwtr (ErrorWriter.)]
    (binding [*out* errwtr
              *err* errwtr]
      (f))))
