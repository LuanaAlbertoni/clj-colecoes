(ns loja.aula1)

; TIPOS DE COLECOES
;Vetor com varios elementos: ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]
;Mapa associativo, dicionario: { "guilherme" 37, "paulo" 39}
;lista ligada: '(1 2 3 4 5)
;Tem ou nao tem: [[0 1]]
;conjunto: #{}


; map
; reduce
; filter


(map println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
(println (first ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
;depois do primeiro elemento
(println (rest ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
;depois do primeiro elemento, pode ser utilizado para descobrir quando acabou
(println (next ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))

;varias funcoes quando devolvem um valor estao devolvendo uma sequencia

(println (seq []))
(println (seq [1 2 3 4 5]))


(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (funcao primeiro)
    (meu-mapa funcao (rest sequencia))))

;(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"] )

(println "\n\n Mapa com parada \n")
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if primeiro
      (do (funcao primeiro) (meu-mapa funcao (rest sequencia))))))

(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"] )
(meu-mapa println ["daniela" false "carlos" "paulo" "lucia" "ana"] )

(println "\n\n Mapa com parada no nil \n")

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do (funcao primeiro) (meu-mapa funcao (rest sequencia))))))

(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"] )
(meu-mapa println ["daniela" false "carlos" "paulo" "lucia" "ana"] )
(meu-mapa println [] )

;(meu-mapa println (range 100))


(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do (funcao primeiro) (recur funcao (rest sequencia))))))


(meu-mapa println (range 100))


