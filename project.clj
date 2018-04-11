(defproject me.arrdem/sounds-of-silence "_"
  :description "Silence is golden."
  :url "http://github.com/arrdem/sound-of-silence"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]]
  :source-paths ["src/clj"]
  :java-source-paths ["src/jvm"]

  :plugins [[me.arrdem/lein-git-version "2.0.8"]]
  :git-version
  {:status-to-version
   (fn [{:keys [tag version branch ahead ahead? dirty?] :as git}]
     (if (and tag (not ahead?) (not dirty?))
       (do (assert (re-find #"\d+\.\d+\.\d+" tag)
                   "Tag is assumed to be a raw SemVer version")
           tag)
       (if (and tag (or ahead? dirty?))
         (let [[_ prefix patch] (re-find #"(\d+\.\d+)\.(\d+)" tag)
               patch            (Long/parseLong patch)
               patch+           (inc patch)]
           (if (not= branch "master")
             (format "%s.%d-%s-SNAPSHOT" prefix patch+ branch)
             (format "%s.%d-SNAPSHOT" prefix patch+)))
         "0.1.0-SNAPSHOT")))})
