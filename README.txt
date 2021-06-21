PD 12. Selenium - zaawansowany
Zad. 1
Utworzenie klasy w konwencji Page Object Model dla sekcji faktury dla firmy zagranicznej (formularz po kliknieciu "Chcę otrzymać fakturę")

Ścieżka w projekcie - /src/main/java/Pages/InvoiceFormPage
Nie ma tutaj kliknięcia checkboxa "Chcę otrzymać fakturę" bo klasa musi być zainicjalizowana już PO kliknięciu checkboxa. Kliknięcie jest pod FormPage


Page Factory
Metody wykonujące akcje dla elementów w formularzu
Zad. 2

Utworzenie uniwersalnej metody w klasie pomocniej (np. PageAction ze szkolenia) pozwalające na zaznaczenie dowolnego checkbox na stronie SzybkichNadań.

Ścieżka w projekcie - /src/main/java/Helpers/CommonHelper/moveAndClick(WebElement element)
zostanie zaznaczony dowolny checkbox jeżeli będzie wprowadzony odpowiedni element - nie wiem czy o to chodziło

Dałam też bezpośrednio pod /src oba pliki