----

----

# Wzorzec Adapter

----

----

## Opis

*Wzorzec Adapter umożliwia integrację komponentów z różnymi formatami danych, przekształcając je do wspólnego standardu wymaganego przez system. W tym projekcie wzorzec Adapter pozwala na importowanie danych o książkach zapisanych w formatach CSV, JSON i XML, przekształcając je do standardowego formatu używanego w aplikacji(LibraryCatalog).*

----

## Struktura i Klasy

----
1. Interfejs BookDataImporter

*Interfejs definiuje metodę importBooks, która przyjmuje dane w postaci tekstu i zwraca listę obiektów typu Book.*

----

2. CSVBookImporter

*Adapter do przetwarzania danych w formacie CSV. Każda linia pliku reprezentuje jedną książkę w formacie:*

*Tytuł,Autor,Rok*

----

3. JSONBookImporter

*Adapter do przetwarzania danych w formacie JSON. Oczekiwany format danych:*

[
  {"title": "Tytuł1", "author": "Autor1", "year": 2021},
  {"title": "Tytuł2", "author": "Autor2", "year": 2020}
]

----

4. XMLBookImporter

*Adapter do przetwarzania danych w formacie XML. Oczekiwany format danych:*

<books>
    <book>
        <title>Tytuł1</title>
        <author>Autor1</author>
        <year>2021</year>
    </book>
    <book>
        <title>Tytuł2</title>
        <author>Autor2</author>
        <year>2020</year>
    </book>
</books>

----

### Zalety Wzorca Adapter w Projekcie

* Elastyczność: Umożliwia rozszerzenie systemu o nowe formaty danych bez modyfikacji istniejącego kodu.

* Reużywalność: Importery mogą być wykorzystywane wielokrotnie w różnych częściach systemu.

* Zasada Open/Closed: Kod jest otwarty na rozszerzenia (nowe formaty) i zamknięty na modyfikacje (istniejąca logika pozostaje niezmieniona).