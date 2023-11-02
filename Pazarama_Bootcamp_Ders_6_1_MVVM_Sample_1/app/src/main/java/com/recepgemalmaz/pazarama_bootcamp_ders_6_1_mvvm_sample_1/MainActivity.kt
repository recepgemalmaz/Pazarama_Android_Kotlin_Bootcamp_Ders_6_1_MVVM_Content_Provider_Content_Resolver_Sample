package com.recepgemalmaz.pazarama_bootcamp_ders_6_1_mvvm_sample_1

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.recepgemalmaz.pazarama_bootcamp_ders_6_1_mvvm_sample_1.models.Person
import com.recepgemalmaz.pazarama_bootcamp_ders_6_1_mvvm_sample_1.ui.theme.Pazarama_Bootcamp_Ders_6_1_MVVM_Sample_1Theme
import com.recepgemalmaz.pazarama_bootcamp_ders_6_1_mvvm_sample_1.viewModels.PersonVM

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var vm: PersonVM = PersonVM(RehberRepository(this))

        vm.People.forEach {
            Log.e("ql", it.name.toString() + " " + it.phone.toString() + " " + it.id.toString())
        }

        var lv = ListView(this)

        lv.adapter = PeopleAdapter(this, vm)

        setContentView(lv)
        /*
        setContent {
            Pazarama_Bootcamp_Ders_6_1_MVVM_Sample_1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PersonListDisplay(vm.People)

                }
            }
        }

         */
    }
}

@Composable
fun PersonDisplay(p: Person) {
    var context = LocalContext.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.LightGray)
            .clickable{
                Toast.makeText(context, p.name.toString(), Toast.LENGTH_SHORT).show()
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.person),
            contentDescription = "Person",
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                //.border(3.dp, Color.Black, CircleShape) //cerceve olusturur
                //.clip(CircleShape) //resmi yuvarlak yapar
        )
        Spacer(
            modifier = Modifier
                .width(10.dp)
                .height(10.dp)
        )
        Text(
            text = p.id!!,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Red
        )
        Spacer(
            modifier = Modifier
                .width(10.dp)
                .height(10.dp)
        )
        Text(
            text = p.name!!,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Blue
        )
        Spacer(
            modifier = Modifier
                .width(10.dp)
                .height(10.dp)
        )
        Text(
            text = p.phone!!,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Magenta
        )
        Spacer(
            modifier = Modifier
                .width(10.dp)
                .height(10.dp)
        )

    }

}

@Composable
fun PersonListDisplay(lst: MutableList<Person>) {

    LazyColumn(contentPadding = PaddingValues(5.dp), userScrollEnabled = true) {

        this.items(lst)
        {
            PersonDisplay(p = it)
        }
    }

}
