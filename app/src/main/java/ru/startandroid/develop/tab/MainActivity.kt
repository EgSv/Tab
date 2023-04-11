package ru.startandroid.develop.tab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TabHost
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    /** Called when the activity is first created.  */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tabHost = findViewById<TabHost>(android.R.id.tabhost)
        // инициализация
        tabHost.setup()
        var tabSpec: TabHost.TabSpec?

        // создаем вкладку и указываем тег
        tabSpec = tabHost.newTabSpec("tag1")
        // название вкладки
        tabSpec.setIndicator("Вкладка 1")
        // указываем id компонента из FrameLayout, он и станет содержимым
        tabSpec.setContent(R.id.tvTab1)
        // добавляем в корневой элемент
        tabHost.addTab(tabSpec)
        tabSpec = tabHost.newTabSpec("tag2")
        // указываем название и картинку
        // в нашем случае вместо картинки идет xml-файл,
        // который определяет картинку по состоянию вкладки
        tabSpec.setIndicator("Вкладка 2", resources.getDrawable(R.drawable.tab_icon_selector))
        tabSpec.setContent(R.id.tvTab2)
        tabHost.addTab(tabSpec)
        tabSpec = tabHost.newTabSpec("tag3")
        // создаем View из layout-файла
        val v: View = layoutInflater.inflate(R.layout.tab_header, null)
        // и устанавливаем его, как заголовок
        tabSpec.setIndicator(v)
        tabSpec.setContent(R.id.tvTab3)
        tabHost.addTab(tabSpec)

        // вторая вкладка будет выбрана по умолчанию
        tabHost.setCurrentTabByTag("tag2")

        // обработчик переключения вкладок
        tabHost.setOnTabChangedListener { tabId ->
            Toast.makeText(baseContext,
                "tabId = $tabId",
                Toast.LENGTH_SHORT).show()
        }
    }
}