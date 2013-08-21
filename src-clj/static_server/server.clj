(ns static-server.server
  (:require [ring.middleware.resource :as resources]))

(def app
  "Minimal server that just serves up static files from resources/public"
  (-> (fn [request] true)
      (resources/wrap-resource "public")))
