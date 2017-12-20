(ns sounds-of-silence-test
  (:require [clojure.test :refer :all]
            [sounds-of-silence :refer :all])
  (:import [java.io IOException]))

(deftest test-not-written
  (testing "NullWriter masks all writes."
    (is (= "" (with-out-str (silence (fn [] (println "foo"))))))))

(deftest test-thrown-when-lamenting
  (testing "Lamentaiton throws on writes."
    (is (thrown? IOException
                 (lamentation (fn [] (println "foo")))))))
