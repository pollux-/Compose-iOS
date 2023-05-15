import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.icerockdev.app.MR
import dev.icerock.moko.resources.compose.stringResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MySootheTheme {
        Scaffold(bottomBar = { SootheBottomNavigation() }) {
            HomeScreen(Modifier.padding(it))
        }
    }
}


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier.padding(top = 16.dp)
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        Spacer(Modifier.height(20.dp))
        placeList()
        Spacer(Modifier.height(16.dp))

    }
}


@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
) {
    TextField(value = "",
        onValueChange = {},
        leadingIcon = { Icon(Icons.Default.Search, "") },
        modifier = modifier
            .heightIn(54.dp)
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(MaterialTheme.colors.surface), placeholder = {
            Text(
                text = "Search"
            )

        })

}


@Composable
fun placeList() {
    LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
        items(places) {
            Row {
                Icon(Icons.Default.Spa, "", modifier = Modifier.padding(end = 16.dp))
                Text(text = it, modifier = Modifier.height(40.dp))
            }
        }
    }

}


@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(modifier, backgroundColor = MaterialTheme.colors.background) {
        BottomNavigationItem(selected = true, onClick = { /*TODO*/ }, icon = {
            Icon(
                imageVector = Icons.Default.Spa,
                contentDescription = ""
            )
        }, label = { Text(text = "Home") })

        BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = ""
            )
        }, label = { Text(text = "Profile") })

    }
}

expect fun getPlatformName(): String