package com.example.autoinstitut

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_user.*
import java.util.*

class CreateUserActivity : AppCompatActivity() {
    // объявляем переменную для генерации автара по умолчанию картинка с именем profileDefault
    var userAvatar = "profileDefault"
    var avatarColor = "[0.5,0.5,0.5,1]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }
    // Генерируем по нажатию кнопки "СГЕНЕРИРОВАТЬ АВАТАР" картинку из списка drawable
    fun generateUserAvatar (view: View) {
        // Обявляем переменую random для  случайной генерации
        val random = Random ()
        val color = random.nextInt(2)
        val avatar =random.nextInt(28)
        //проверяем цвет
        if (color ==0) {
            userAvatar = "light$avatar"
        }else{
            userAvatar = "dark$avatar"
        }
        val resourceId  =resources.getIdentifier(userAvatar, "drawable", packageName)
        createAvatarImageView.setImageResource(resourceId)
    }
    // Генерируем по нажатию кнопки "ИЗМЕНИТЬ ЦВЕТ ФОНА" фон аватара
    fun backgroundColorClicked (view: View) {
        val random = Random ()
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)
        createAvatarImageView.setBackgroundColor(Color.rgb(r,g,b))
            //сохроняем последнее значение rgb
        val savedR =r.toDouble() /255
        val savedG =g.toDouble() /255
        val savedB =b.toDouble() /255
        avatarColor ="[$savedR, $savedG, $savedB, 1]"
       // просмотр данных фона- println(avatarColor)

    }
    fun createUserClicked (view: View) {}
}
