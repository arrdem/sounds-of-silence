(defproject me.arrdem/sounds-of-silence "_"
  :description "Silence is golden."
  :url "http://github.com/arrdem/sound-of-silence"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]] 
  :source-paths ["src/clj"]
  :java-source-paths ["src/jvm"]

  :plugins [[me.arrdem/lein-git-version "2.0.3"]]
  :git-version {:status-to-version
                (fn [{:keys [tag version ahead ahead? dirty?]
                      :or   {tag "0.1.0"}}]
                  (if (and tag (not ahead?))
                    tag
                    (str tag "-" ahead (when dirty? "-SNAPSHOT"))))})
