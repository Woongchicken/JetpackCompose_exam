@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.surivalcoding.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import kotlin.math.pow

@OptIn(ExperimentalComposeUiApi::class)
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            HomeScreen(viewModel)
        }


//        setContent{
//            // data를 뷰 모델 안으로...
//            val data = remember {
//                mutableStateOf("Test")
//            }
//
//
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ){
//                Text(
//                    // data.value,
//                    viewModel.data.value,
//                    fontSize = 30.sp
//                )
//                Button(onClick = {
//                    // data.value = "Change"
//                    // viewModel.data.value
//                    viewModel.changeValue()
//                }) {
//                    Text("변경")
//                }
//            }
//        }

//        setContent {
//            val navController = rememberNavController()
//
//            NavHost(
//                navController = navController,
//                startDestination = "first"
//            ) {
//                composable("first") {
//                    FirstScreen(navController)
//                }
//                composable("second") {
//                    SecondScreen(navController)
//                }
//                composable("third/{value}") { backStackEntry ->
//                    ThirdScreen(
//                        navController = navController,
//                        value = backStackEntry.arguments?.getString("value") ?: ""
//                    )
//                }
//            }
//        }

        /** # 텍스트 받기 - 구조 분해 (MutableState -> String, Unit) */
//        setContent{
//            // text - getter, setValue - setter
//            val (text, setValue) = remember {
//                mutableStateOf("")
//            }
//
//            // 최근의 상태를 저장
//            // val scaffoldState = rememberScaffoldState()
//            val snackbarHostState = remember { SnackbarHostState() }
//            val scope = rememberCoroutineScope()
//            val keyboardController = LocalSoftwareKeyboardController.current
//
//            // Scaffold - 기본 Material 뼈대, 스낵바 같은 요소 사용가능
//            Scaffold(
//               //  scaffoldState = scaffoldState
//                snackbarHost = { SnackbarHost(snackbarHostState) }
//            ) {
//                Column(
//                    modifier = Modifier.fillMaxSize(),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    TextField(
//                        value = text,
//                        onValueChange =  setValue
//                    )
//                    Button(onClick = {
//                        keyboardController?.hide()
//                        // showSnackbar는 suspend 키워드 내에서 실행 -> 코루틴에서 실행
//                        scope.launch {
//                            snackbarHostState.showSnackbar("Hello $text")
//                        }
//
//                    }) {
//                        Text("클릭!!")
//                    }
//                }
//            }
//
//        }


        /** # 텍스트 받기 - 일반적인 방법 */
//        setContent{
//            val textValue = remember {
//                mutableStateOf("")
//            }
//
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                TextField(
//                    value = textValue.value,
//                    onValueChange =  {
//                        textValue.value = it
//                    }
//                )
//                Button(onClick = {}) {
//                    Text("클릭!!")
//                }
//            }
//        }


//        setContent {
//            // rememberSaveable - 화면 회전시에도 값 저장
//            var isFavorite by rememberSaveable {
//                mutableStateOf(false)
//            }
//
//            ImageCard(
//                // modifier를 외부에서 설정해서, ImageCard를 재사용 가능하도록 설정
//                modifier = Modifier
//                    .fillMaxWidth(0.5f)
//                    .padding(16.dp),
//                isFavorite = isFavorite,
//            ) { favorite ->
//                isFavorite = favorite
//
//            }
//        }

        // LazyColumn - 리사이클러 뷰와 유사, 화면에 보이는 아이템만 렌더링, 대량의 데이터를 보여줄 때 효율적
        //              스크롤할 때 아이템이 동적으로 로드, 화면 밖으로 벗어난 아이템은 메모리에서 제거


//        setContent {
//            LazyColumn(
//                modifier = Modifier
//                    .background(color = Color.Green)
//                    .fillMaxWidth(),
//                contentPadding = PaddingValues(16.dp),
//                verticalArrangement = Arrangement.spacedBy(8.dp)
//
//            ) {
//                item {
//                    Text("Header")
//                }
//                items(50) { index ->
//                    Text("글씨 $index")
//                }
//                item {
//                    Text("Footer")
//                }
//
//            }
//        }


        // Column -  모든 자식 컴포넌트를 한 번에 렌더링, 화면에 보이지 않는 아이템까지 모두 메모리에 로드 (아이템 수가 많아질수록 성능에 부담)
        //           작은 양의 데이터나 간단한 UI를 구성할 때 적합합니다.

//        setContent {
//            val scrollState = rememberScrollState()     // 스크롤 상태를 기억
//            Column(
//                modifier = Modifier
//                    .background(color = Color.Green)
//                    .fillMaxWidth()
//                    .verticalScroll(scrollState)
//            ) {
//                for (i in 1..50) {
//                    Text("B글씨 $i")
//                }
//            }
//        }



//        setContent {
//            // Box - 중첩 가능 , Box 안에 Box를 만들어줌.
//            Box(
//                modifier = Modifier
//                .background(color = Color.Green)
//                .fillMaxWidth()
//                .height(200.dp)
//            ) {
//              Text("Test")
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(0.dp,0.dp,0.dp,16.dp),
//                    contentAlignment = Alignment.BottomEnd
//                ){
//                    Text("Woong")
//                }
//            }
//        }


//        setContent {
//            Surface(color = MaterialTheme.colorScheme.background){
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                    .background(color = Color.Blue)
//                    .padding(16.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.SpaceBetween,
//                ) {
//                    Greeting("Android")
//                    Text("Test")
//                    Spacer(Modifier.width(16.dp))
//                    Text("ㄸㄸㄷ")
//                }
//
//                Row{
//                    Greeting("Row Test")
//                }
//            }
//        }

    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    onTabFavorite: (Boolean) -> Unit
) {
    Card(
        modifier = modifier,
//        modifier = Modifier
//            .fillMaxWidth(0.5f)
//            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 200.dp
        )
    ) {
        Box(
            modifier = Modifier.height(200.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.poster3),
                contentDescription = "poster3",
                contentScale = ContentScale.Crop
                // contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopEnd,
            ) {
                IconButton(onClick = {
                    // isFavorite = !isFavorite
                    onTabFavorite.invoke(!isFavorite)
                }) {
                    Icon(
                        imageVector = if (isFavorite)  Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "favorite",
                        tint = Color.White
                    )
                }
            }

        }


    }
}


@Composable
fun FirstScreen(navController: NavController) {
//    val (value, setValue) = remember {
//        mutableStateOf("")
//    }

    val (value, setValue) = rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "첫 화면")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("second") }) {
            Text(text = "두 번째!")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = value, onValueChange = setValue)
        Button(onClick = {
            if (value.isNotEmpty()){
                navController.navigate("third/$value")
            }
        }) {
            Text(text = "세 번째!")
        }
    }

}

@Composable
fun SecondScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "두 번째 화면")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // navController.navigateUp()
            navController.popBackStack()
        }) {
            Text(text = "뒤로 가기!")
        }
    }

}

@Composable
fun ThirdScreen(navController: NavController, value : String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "세 번째 화면")
        Spacer(modifier = Modifier.height(16.dp))
        Text(value)
        Button(onClick = {
            navController.navigateUp()
        }) {
            Text(text = "뒤로 가기!")
        }
    }
}


/** State 심화 */
@Composable
fun HomeScreen(viewModel: MainViewModel = viewModel()) {
    // 한번 할당 되고, 안에 있는 값을 변경 -> val, value로 접근
    val text1: MutableState<String> = remember {
        mutableStateOf("Test")
    }

    // 자체를 변경 -> var, by - 권한 위임(setter, getter 재정의)
    var text2: String by remember {
        mutableStateOf("Test")
    }

    // text3 - getter, setText - setter
    val (text3: String, setText: (String) -> Unit) = remember {
        mutableStateOf("Test")
    }

    // observeAsState - 기존에 있던 LiveData 활용
    val text4: State<String> = viewModel.liveData.observeAsState(initial = "test")

    Column {
        Text("Test")
        Button(onClick = {
            text1.value = "변경1"
            print(text1.value)
            text2 = "변경2"
            print(text2)
            // text3 = "변경"     // val
            setText("변경3")   // setter
            print(text3)
            // viewModel.value.value = "변경"
            viewModel.changeValue("변경")
        }) {
            Text("클릭")
        }
        TextField(value = text3, onValueChange = setText)
    }
}

// ViewModel - Activity - LifeCycle을 동일하게 가져가기때문에 remember에 신경 X
class MainViewModel : ViewModel() {
    // compose
    private val _value : MutableState<String> = mutableStateOf("Test")  // mutableStateOf - 쓰기,일기 가능
    val value : State<String> = _value                  // State - 읽기만 가능

    // 데이터 수정할때 매서드로 수정
    fun changeValue(value: String) {
        _value.value = value
    }

    // liveData
    private val _liveData = MutableLiveData<String>()
    val liveData : LiveData<String> = _liveData

   
    

}
