----
----

# Wzorzec Oberver

----

----

----
## Opis

Ten projekt demonstruje implementację wzorca projektowego Observer w kontekście katalogu biblioteki, w którym użytkownicy (obserwatorzy) subskrybują powiadomienia o zmianach w katalogu książek, takich jak dodanie nowej książki, wypożyczenie lub zwrot książki.

----

## Jak działa wzorzec Observer w tym projekcie?

1. Dodanie książki:

Kiedy książka jest dodana do katalogu (LibraryCatalog), informacja o tym zdarzeniu jest wysyłana do wszystkich obserwatorów (użytkowników) subskrybujących ten katalog.

2. Wypożyczenie książki:

Kiedy książka jest wypożyczona, podmiot (LibraryCatalog) powiadamia subskrybentów, że książka została wypożyczona.

3. Zwrócenie książki:

Podobnie, po zwrocie książki do katalogu, wszyscy obserwatorzy są informowani o tym wydarzeniu.