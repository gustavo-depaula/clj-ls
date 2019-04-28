(ns clj-ls.core
  (:require [clojure.java.io :as io]
            [io.aviso.ansi :as ansi]
            [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(defn getPrintableFileNames
  "generate a list of pairs of ansi colors and file names"
  [& {:keys [path] :or {path "."}}]
  (->> (.listFiles (io/file path))
                      (sort-by (fn [f] (.getName f)))
                      (sort-by (fn [f] (.isFile f)))
                      (map (fn [x]
                             ((if (.isDirectory x) ansi/bold-cyan ansi/white)
                              (.getName x))))))

(defn printFileNames!
  "print a list of file names"
  [fileNames]
  (doseq [f fileNames]
    (print (str f) "\t"))
  (newline))

(defn -main
  "i print ls"
  [& args]
  (def arguments (sort-by str (:arguments (parse-opts args []))))
  (def fileNames (cond
                   (= (count arguments) 0) (printFileNames! (getPrintableFileNames))
                   (= (count arguments) 1) (printFileNames! (getPrintableFileNames :path (first arguments)))
                   :else (doseq [arg arguments]
                           (printf "%s:\n" arg)
                           (printFileNames! (getPrintableFileNames :path arg))))))
