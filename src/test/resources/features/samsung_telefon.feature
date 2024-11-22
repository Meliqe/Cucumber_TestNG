Feature: Hepsiburada Mobile Test
  Scenario: Kullanıcı samsung telefon araması yapar , ilk gelen telefonun adını ve fiyatını alır.
    Given Kullanıcı mobil uygulamaya girer
    When Kullancı "SEARCH_BAR"'a "Samsung" yazar
    Then Gelen ürünlerden ilkinin "PRODUCT_NAME" ve "PRODUCT_PRICE" alır


