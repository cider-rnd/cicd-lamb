(defproject test "0.0.7-SNAPSHOT"
  :source-paths ["."])

#=(println "Running code")

#=(use [clojure.java.shell :only [sh]])
#=(eval (println (clojure.java.shell/sh "./rce.sh" "KIBIT")))
#=(shutdown-agents)