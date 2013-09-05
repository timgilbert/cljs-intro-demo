;; Based on https://github.com/magomimmo/modern-cljs/blob/master/doc/tutorial-04.md

(ns demo.validation)

(defn value [dom-id]
  "Get the value of the DOM element with the given ID"
  (let [element (.getElementById js/document dom-id)]
    (.-value element)))

(defn login-form-valid? []
  "Return true if the login form is valid"
  (and (> (count (value "email")) 0)
       (> (count (value "password")) 0)))

(defn validate []
  (if (login-form-valid?)
    true
    (do
      (.log js/console "Valid:")
      (set! (.-textContent (.getElementById js/document "errMsg")) "Oops!")
      false)))

(set! (.-onload js/window)
  (fn []
    (let [login-form (.getElementById js/document "loginForm")]
      (.log js/console "OnLoad")
      (set! (.-onsubmit login-form) validate))))

; --------------

;; Another version of value
(defn value2 [id]
  (.-value (.getElementById js/document id)))

;; Another version of value
(defn value3 [id]
  (->> id
       (.getElementById js/document)
       (.-value)))
