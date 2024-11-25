Feature: Hepsiburada Mobile Test
  Scenario: Kullanıcı samsung telefon araması yapar , ilk gelen telefonun adını ve fiyatını alır.
    Given Kullanıcı mobil uygulamaya girer
    When "SEARCH_BAR"'a tıklar
    And Kullancı "SEARCH_BAR"'a "Samsung Telefon" yazar
    Then Gelen ürünlerden ilkinin "PRODUCT_NAME" ve "PRODUCT_PRICE" alır


