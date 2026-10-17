# ConnectTag Formatter Kit (`formatter-kit`)

[![JitPack](https://jitpack.io/v/connecttag/formatter-kit.svg)](https://jitpack.io/#connecttag/formatter-kit)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

مكتبة KMP خفيفة وسريعة لتنسيق أحجام الملفات والبيانات، سرعات الشبكة والتدفق، ومعدل البت ومحسوب الحزم والتواريخ:
- **Android** (API 24+)
- **Desktop JVM** (Windows, macOS, Linux)

---

## 📦 التثبيت والإضافة للمشروع (Installation)

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

dependencies {
    implementation("com.github.connecttag:formatter-kit:1.0.0")
}
```

---

## 🌟 الميزات (Features)

- 📊 **`SizeFormatter.formatFileSize(bytes)`**: تحويل البايتات إلى صيغة مقروءة (`1.5 MB`، `2.4 GB`).
- ⚡ **`SizeFormatter.formatSpeed(bytesPerSec)`**: حساب سرعة النقل الحالية (`1.2 MB/s`).
- 📶 **`SizeFormatter.formatBitrate(bitsPerSec)`**: حساب معدل نقل البتات (`15 Mbps`).
- 📦 **`SizeFormatter.formatPackets(count)`**: تمثيل أعداد الحزم (`1.2K pkts`).
- 🕒 **`DateFormatter`**: تحويل الطوابع الزمنية وصيغ ISO والساعات بنظام 12 ساعة.

---

## 🛡️ الترخيص (License)
مرخصة تحت رخصة [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0.txt).
