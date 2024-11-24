# Wzorzec Singleton

----

## Co wiemy?

```
Singleton to wzorzec projektowy, 
który gwarantuje istnienie dokładnie jednej instancji danej klasy w całej aplikacji i umożliwia globalny dostęp do niej. 
Jest używany w sytuacjach, gdzie posiadanie wielu instancji mogłoby prowadzić do błędów lub być niewydajne. 
Przykładami zastosowań są: połączenia z bazą danych, logger, czy konfiguracja systemu.
```
----
## Zalety Singletona
* Kontrola liczby instancji: Upewnia się, że klasa ma tylko jedną instancję.
* Globalny dostęp: Wszystkie części aplikacji korzystają z tej samej instancji.

----

## Przykładowe przypadki użycia Wzorca Singleton:

1. Ograniczenie liczby instancji do jednej, np. dla połączenia z bazą danych, loggera lub konfiguracji
    systemu. Każda kolejna instancja jest zbędna i może być kosztowna.


2. Kontrola zasobów w aplikacjach wielowątkowych, gdzie jednoczesny dostęp do wielu instancji
    danej klasy może prowadzić do konfliktów lub nieoczekiwanych zachowań.

----
## Problemy związane z Singletonem

1. Utrudnione testowanie i zależności: Jako globalna instancja, może łamać zasady hermetyzacji, prowadząc do trudności w testowaniu i obniżeniu modularności kodu.


2. Zarządzanie pamięcią: Singletony przechowywane jako pola statyczne pozostają w pamięci przez cały czas działania aplikacji, co może prowadzić do wycieków pamięci, zwłaszcza jeśli odwołują się do dużych lub dynamicznych danych.


3. Problemy z synchronizacją: W środowiskach wielowątkowych mogą pojawiać się trudności z zapewnieniem poprawnego działania mechanizmów zapobiegających powielaniu instancji.

----

----

# O Projekcie

----

----

*Opis*

````
 Zastosowanie: Implementacja klasy LibraryCatalog, która zapewnia, że w programie istnieje tylko jedna instancja katalogu. Klasa ta będzie odpowiedzialna za przechowywanie i zarządzanie danymi o książkach.
````

**Rodzaje implmentacji Singleton:**

----

1. Leniwa inicjalizacja

**Takie podejście powoduje utworzenie instancji singletonu tylko wtedy, gdy jest ona potrzebna, co pozwala zaoszczędzić zasoby, jeśli singleton nigdy nie zostanie użyty w aplikacji.**

*Kod:*

````
Sprawdza, czy wystąpienie już istnieje ( instance == null).

W przeciwnym razie tworzona jest nowa instancja.

Jeśli instancja już istnieje, pomija krok tworzenia.

Ta implementacja nie jest bezpieczna dla wątków. 
Jeśli wiele wątków wywołuje getInstance() jednocześnie, gdy instance jest null, możliwe jest utworzenie wielu wystąpień.

````

----

2. Thread-Safe Singleton

**To podejście jest podobne do inicjalizacji leniwej, ale dodatkowo zapewnia, że ​​singleton jest bezpieczny dla wątków.
Osiąga się to poprzez zsynchronizowanie getInstance()metody , co gwarantuje, że tylko jeden wątek może wykonywać tę metodę w danym momencie.
Gdy wątek wchodzi do metody synchronized, uzyskuje blokadę obiektu klasy. Inne wątki muszą czekać, aż metoda zostanie wykonana.**

*Kod:*

```
Słowo kluczowe synchronization zapewnia, że tylko jeden wątek może wykonać (instance == null)(sprawdzenie) i utworzyć obiekt.

Jeśli wywołanie getInstance() metody nie powoduje znacznego obciążenia, takie podejście jest proste i skuteczne.

Jednak użycie tej funkcji synchronized może spowodować spadek wydajności, co może stanowić wąskie gardło przy częstym wywoływaniu.

```

----

3. Double-Checked Locking

**Takie podejście minimalizuje obciążenie wydajności wynikające z synchronizacji, ponieważ synchronizacja jest wykonywana tylko wtedy, gdy obiekt jest tworzony po raz pierwszy.
Używa volatile (słowa kluczowego) , aby zapewnić, że zmiany w zmiennej instancji będą natychmiast widoczne dla innych wątków.**

*Kod:*

```
Jeśli pierwsze sprawdzenie (instancja == null) przejdzie pomyślnie, synchronizujemy obiekt klasy.

Sprawdzamy ten sam warunek jeszcze raz, ponieważ wiele wątków mogło przejść pierwszą kontrolę.

Instancja jest tworzona tylko wtedy, gdy obie kontrole przejdą pomyślnie.

Mimo że ta metoda jest nieco skomplikowana w implementacji, może ona znacznie zmniejszyć obciążenie wydajności.

```

----

4. Bill Pugh Singleton

**Ta implementacja używa statycznej klasy pomocniczej wewnętrznej do przechowywania instancji singleton. Klasa wewnętrzna nie jest ładowana do pamięci, dopóki nie zostanie odwołana po raz pierwszy w getInstance() metodzie.
Jest bezpieczny dla wątków i nie wymaga jawnej synchronizacji.**

*Kod:*

```
Klasa Holder jest opakowaniem, które przechowuje jedyną instancję klasy LibraryCatalog. Instancja LibraryCatalog zostanie utworzona dopiero, gdy klasa Holder zostanie załadowana przez JVM.

Gdy wywołamy LibraryCatalog.getInstance(), klasa Holder zostanie załadowana, a jedyna instancja LibraryCatalog zostanie zwrócona. 

Bezpieczeństwo wielowątkowe: Mechanizm inicjalizacji statycznej w Javie zapewnia, że klasa Holder jest ładowana tylko raz, co eliminuje problemy z równoczesnym dostępem w środowisku wielowątkowym.
```

5. Enum Singleton

**W tej metodzie singleton jest zadeklarowany jako enum, a nie klasa.
Java zapewnia, że tworzona jest tylko jedna instancja wartości enum, nawet w środowisku wielowątkowym.
Wzorzec Singleton Enum jest najbardziej niezawodnym i zwięzłym sposobem implementacji singletonów w Javie.**

*Kod:*

````
Wielu ekspertów Java poleca Enum Singleton jako najlepszą implementację singletonów w Javie.
Jednak nie zawsze jest ona odpowiednia, zwłaszcza jeśli musisz rozszerzyć klasę lub jeśli leniwa inicjalizacja jest ścisłym wymogiem.
````