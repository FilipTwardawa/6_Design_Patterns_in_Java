----

----

# Wzorzec Factory

----

----

## Opis projektu
Projekt demonstruje implementację wzorca projektowego Factory w języku Java, w kontekście systemu bibliotecznego. Wzorzec Factory służy do centralizacji logiki tworzenia obiektów, co zwiększa przejrzystość, ułatwia zarządzanie kodem i poprawia jego rozszerzalność.

W aplikacji implementujemy UserFactory, która tworzy różne typy użytkowników biblioteki (Student, Teacher, Librarian) na podstawie parametrów wejściowych. Każdy użytkownik posiada inne uprawnienia dotyczące maksymalnej liczby książek, które może wypożyczyć.

## Funkcjonalności

1. Tworzenie różnych typów użytkowników biblioteki:

* Student – limit: 3 książki.

* Teacher – limit: 10 książek.

* Librarian – nielimitowany dostęp.

2. Zarządzanie książkami w bibliotece (dodawanie, wyświetlanie, wypożyczanie).

3. Centralizacja logiki tworzenia obiektów za pomocą wzorca Factory.

```

src/
│
├── model/
│   ├── Book.java          // Model książki
│   ├── User.java          // Klasa bazowa użytkownika
│   ├── Student.java       // Konkretna implementacja dla Student
│   ├── Teacher.java       // Konkretna implementacja dla Teacher
│   └── Librarian.java     // Konkretna implementacja dla Librarian
│
├── factory/
│   └── UserFactory.java   // Fabryka użytkowników
│
├── service/
│   └── LibraryService.java // Serwis zarządzający biblioteką
│
└── Main.java               // Główny plik projektu
```

## Użyte wzorce projektowe i dobre praktyki

1. Factory (Factory Method):

UserFactory centralizuje tworzenie obiektów różnych typów użytkowników.

Klient nie zna szczegółów implementacji (Student, Teacher, Librarian), co zapewnia luźne powiązanie kodu.

2. SOLID:

* Single Responsibility Principle (SRP): Każda klasa ma jasno określoną odpowiedzialność (np. UserFactory tworzy użytkowników, LibraryService zarządza logiką biblioteki).
* Open/Closed Principle (OCP): Łatwo dodać nowy typ użytkownika bez modyfikacji istniejącego kodu.
DRY (Don't Repeat Yourself):
Logika tworzenia użytkowników znajduje się w jednym miejscu (UserFactory).

## Coś więcej o Wzorcu Factory?

1. Centralizacja logiki tworzenia obiektów:

Zamiast tworzyć obiekty Student, Teacher lub Librarian bezpośrednio w różnych miejscach kodu, mamy centralny punkt (UserFactory), który odpowiada za to zadanie. Dzięki temu:

* Kod tworzenia jest łatwiejszy do utrzymania.
* Możemy dynamicznie zmieniać typy użytkowników (np. na podstawie danych wejściowych lub konfiguracji).

2. Uniknięcie silnych zależności:
Klient (np. klasa Main) nie zależy od konkretnych klas (Student, Teacher, Librarian). Zamiast tego, polega na abstrakcji User, co oznacza, że:

* Możemy łatwo dodać nowe typy użytkowników bez konieczności modyfikowania kodu klienta.
* Klient wie tylko, że otrzymuje obiekt User, bez znajomości szczegółów implementacyjnych.

3. Dynamiczne tworzenie obiektów:
Fabryka pozwala na dynamiczne określenie typu obiektu podczas działania programu na podstawie np. danych wejściowych:

```User user = UserFactory.createUser(userType, name);```

4. Zgodność z SOLID (Open/Closed Principle):
Dodanie nowego typu użytkownika (np. "Guest") wymaga jedynie:

* Dodania nowej klasy dziedziczącej po User.
* Rozszerzenia metody createUser w UserFactory.
