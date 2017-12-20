(ns sound-of-silence-test
  (:require [clojure.test :refer :all]
            [sound-of-silence :refer :all])
  (:import [java.io IOException]))

(deftest test-not-written
  (testing "NullWriter masks all writes."
    (is (= "" (with-out-str (silence (fn [] (println "foo"))))))))

(deftest test-thrown
  (testing "Screaming throws on writes."
    (is (thrown? IOException
                 (lamentation (fn [] (println "foo")))))))
