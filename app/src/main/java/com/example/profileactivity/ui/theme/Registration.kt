package com.example.profileactivity.ui.theme

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profileactivity.LoginBody
import com.example.profileactivity.ProfileBody
import com.example.profileactivity.R
import com.example.profileactivity.ui.theme.ui.theme.ProfileActivityTheme

class Registration : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold { innerPadding ->
                RegistrationBody(innerPadding)
            }
        }

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationBody(innerPadding: PaddingValues) {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val countries = listOf("Nepal", "India", "USA", "UK")
    var dob by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("Male") }
    var acceptTerms by remember { mutableStateOf(false) }


    val datePickerDialog = rememberDatePickerDialog { dob = it }

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Register")


        Spacer(modifier = Modifier.height(8.dp))

        // 8. First Name Field
        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            modifier = Modifier.fillMaxWidth(),

            label = { Text("First Name") }
        )

        // 9. Last Name Field
        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Last Name") }
        )

        // 10. Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        // 11. Country Dropdown
        ExposedDropdownMenuBox (
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = country,
                onValueChange = {},
                readOnly = true,
                label = { Text("Select Country") },
                trailingIcon = {R.drawable.baseline_arrow_drop_down_24},
                modifier = Modifier.fillMaxWidth())



            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                countries.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            country = selectionOption
                            expanded = false
                        }
                    )
                }
            }
        }

        // 12. DOB Field with date picker
        OutlinedTextField(
            value = dob,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .clickable() { datePickerDialog.show () },
            label = { Text("DOB") },
            readOnly = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 13. Gender Radio Buttons
        Text("Gender")
        Row (verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = gender == "Male",
                onClick = { gender = "Male" }
            )
            Text("Male")
            RadioButton(
                selected = gender == "Female",
                onClick = { gender = "Female" }
            )
            Text("Female")
            RadioButton(
                selected = gender == "Others",
                onClick = { gender = "Others" }
            )
            Text("Others")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 14. Terms and Conditions Checkbox
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(checked = acceptTerms, onCheckedChange = { acceptTerms = it })
            Text("I accept terms and conditions")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 15. Register Button
        Button (
            onClick = { /* Handle registration logic */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Register")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 16. Sign-in Link
        Text(
            text = "Already have Account? Signin",
            modifier = Modifier
                .clickable { /* Navigate to login */ },
            color = Color.Blue
        )
    }
}

@Composable
fun rememberDatePickerDialog(onDateSelected: (String) -> Unit): DatePickerDialog {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    return DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            onDateSelected("dayOfMonth/{month + 1}/year")
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )
}
@Preview(showBackground = true)
@Composable
fun PreviewRegistration(){
    RegistrationBody(innerPadding = PaddingValues(0.dp))
}