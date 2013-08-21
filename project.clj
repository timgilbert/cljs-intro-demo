(defproject cljs-intro-demo "0.1.0-SNAPSHOT"
  :description "Simple demo app"
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :plugins [[lein-cljsbuild "0.3.2"]]
  :cljsbuild {
    :builds {
      :main {
        :source-paths ["src-cljs"]
        :compiler {:output-to "resources/public/js/main.js"
                   :optimizations :whitespace
                   :pretty-print true}}}})