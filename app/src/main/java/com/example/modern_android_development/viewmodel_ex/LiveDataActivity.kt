//package com.example.modern_android_development.viewmodel_ex
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.compose.foundation.Text
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.preferredHeight
//import androidx.compose.foundation.layout.preferredWidth
//import androidx.compose.foundation.layout.wrapContentWidth
//import androidx.compose.foundation.lazy.LazyColumnFor
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Card
//import androidx.compose.material.CircularProgressIndicator
//import androidx.compose.material.ListItem
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.livedata.observeAsState
//import androidx.compose.runtime.mutableStateListOf
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Alignment.Companion.CenterHorizontally
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.setContent
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.ViewModelProvider
//import androidx.ui.tooling.preview.Preview
//
//class LiveDataActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val viewModel = ViewModelProvider(this).get(SuperheroesViewModel::class.java)
//
//        setContent {
//            LiveDataComponent(viewModel.superheroes)
//        }
//    }
//}
//
//@Composable
//fun LiveDataComponent(personListLiveData: LiveData<List<Person>>) {
//    val personList by personListLiveData.observeAsState(initial = emptyList())
//    if (personList.isEmpty()) {
//        LiveDataLoadingComponent()
//    } else {
//        LiveDataComponentList(personList)
//    }
//}
//
//@Composable
//fun LiveDataComponentList(personList: List<Person>) {
//    LazyColumnFor(items = personList) { person ->
//        Card(
//            shape = RoundedCornerShape(4.dp),
//            backgroundColor = Color.White,
//            modifier = Modifier.fillParentMaxWidth().padding(8.dp)
//        ) {
//            ListItem(text = {
//                Text(
//                    text = person.name,
//                    style = TextStyle(
//                        fontFamily = FontFamily.Serif, fontSize = 25.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                )
//            }, secondaryText = {
//                Text(
//                    text = "Age: ${person.age}",
//                    style = TextStyle(
//                        fontFamily = FontFamily.Serif, fontSize = 15.sp,
//                        fontWeight = FontWeight.Light, color = Color.DarkGray
//                    )
//                )
//            }, icon = {
//                person.profilePictureUrl?.let { imageUrl ->
//                    NetworkImageComponentPicasso(
//                        url = imageUrl,
//                        modifier = Modifier.preferredWidth(60.dp).preferredHeight(60.dp)
//                    )
//                }
//            })
//        }
//    }
//}
//
//@Composable
//fun LiveDataLoadingComponent() {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        CircularProgressIndicator(modifier = Modifier.wrapContentWidth(CenterHorizontally))
//    }
//}
//
//@Composable
//fun LaunchInCompositionComponent(viewModel: SuperheroesViewModel) {
//    val personList = mutableStateListOf<Person>()
//    LaunchedEffect(Unit) {
//        val list = viewModel.loadSuperheroes()
//        personList.addAll(list)
//    }
//
//    if (personList.isEmpty()) {
//        LiveDataLoadingComponent()
//        return
//    }
//    LiveDataComponentList(personList)
//}
//
//@Preview
//@Composable
//fun LiveDataComponentListPreview() {
//    LiveDataComponentList(getSuperheroList())
//}
//
//@Preview
//@Composable
//fun LiveDataLoadingComponentPreview() {
//    LiveDataLoadingComponent()
//}
//
