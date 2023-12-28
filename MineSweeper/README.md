# MineSweeper
Java-101 Mayın Tarlası Oyunu
## Nasıl Oynanır

- Oyun, kullanıcıdan oyun tahtasının boyutunu (satır ve sütun sayısını) girmesini ister. Bu en az 2x2 boyutunda bir matris olmalıdır. Aksi halde hata verir.

- Oyun tahtası başlangıçta her hücreyi "-" ile temsil eder.

- Kullanıcı sırayla satır ve sütun numarasını girdiğinde, oyun tahtası açılacaktır.

- Eğer bir mayına bastıysanız, oyun sona erer.

- Oyunu kazanmak için tüm mayınlar dışındaki hücreleri açmalısınız.

## Kod Yapısı

- `MineSweeper` sınıfı oyunun temel işlevlerini yönetir. Kurucu metod, oyun tahtasını başlatır ve mayınları yerleştirir.

- `initializeGame` metodu oyun tahtasını başlatır ve mayınları yerleştirir.

- `placeMines` metodu mayınları rastgele yerleştirir.

- `displayBoard` metodu oyun tahtasını ekrana basar.

- `playGame` metodu oyunu başlatır ve kullanıcının hamlelerini alır.

- `uncoverCell` metodu belirli bir hücreyi açar.

- `countMinesAround` metodu, belirli bir hücre etrafındaki mayınları sayar.

- `isGameWon` metodu oyunun kazanılıp kazanılmadığını kontrol eder.

  Patika+ ekibine teşekkürler :)
