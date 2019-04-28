# clj-ls
a minimal ls command implementation in clojure - for learning purposes  
what did i learn doing this:
- requiring packages and using namespaces
- accessing java classes through clojure/java interop
- fuction and control flow in clojure
- using `main` function arguments
- clojure funky arrows (->, ->>)

## installation
just use leiningen:
``` sh
lein install
```

## about
although it work with the most basic uses of `ls`, i took some artistic licenses
to make this implementation:
- directories come first and are highlighted
- no support for any `ls` flag
- dotfiles are not hidden

# usage
just use leiningen: `lein run [paths ...]`
``` sh
lein run # will list the current directory content
lein run ~/ # will list home's content
lein run ~/ src # will list both home and src contents
```

