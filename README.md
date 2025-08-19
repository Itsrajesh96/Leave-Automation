# 🚀 Leave Automation Framework - Complete CRUD Operations

A comprehensive Selenium Java automation framework for Leave Management System with full CRUD (Create, Read, Update, Delete) operations.

## 🎯 **Framework Overview**

This framework provides complete automation for:
- ✅ **Create** - All leave types (Sick, EarnedLeave, Casual, CompOff)
- ✅ **Read** - Verify leaves in table, check table structure
- ✅ **Update** - Modify leave details (dates, type, reason)
- ✅ **Delete** - Remove leaves with verification
- ✅ **Navigation** - Sidebar menu and direct URL navigation
- ✅ **Table Verification** - Column structure and data validation

## 🏗️ **Project Structure**

```
Leave-Automation/
├── src/
│   ├── main/java/com/employeegalaxy/
│   │   ├── pages/
│   │   │   ├── LoginPage.java          # Login functionality
│   │   │   └── LeavePage.java          # Complete leave operations
│   │   └── utils/                      # Utility classes
│   └── test/java/com/employeegalaxy/tests/
│       ├── TestBase.java               # WebDriver setup and teardown
│       ├── CreateLeaveTest.java        # Create leave test cases
│       ├── UpdateLeaveTest.java        # Update leave test cases
│       ├── DeleteLeaveTest.java        # Delete leave test cases
│       ├── LeaveCRUDTest.java          # Complete CRUD cycle tests
│       ├── NavigationTest.java         # Navigation verification
│       └── DebugPageElementsTest.java  # Element debugging utility
├── pom.xml                             # Maven dependencies
├── simple-tests.xml                    # TestNG test suite
└── README.md                           # This documentation
```

## 🔧 **Prerequisites**

- **Java**: JDK 17 or higher
- **Maven**: 3.6+ for dependency management
- **Chrome Browser**: Latest version
- **IDE**: IntelliJ IDEA, Eclipse, or VS Code

## 📦 **Dependencies**

- **Selenium WebDriver**: 4.26.0
- **TestNG**: 7.10.2 (Testing framework)
- **WebDriverManager**: 5.9.2 (Automatic driver management)
- **ChromeDriver**: Auto-managed by WebDriverManager

## 🚀 **Quick Start**

### **1. Clone and Setup**
```bash
git clone <repository-url>
cd Leave-Automation
mvn clean install
```

### **2. Run Tests**

#### **Option A: Run Complete Test Suite**
```bash
mvn test -DsuiteXmlFile=simple-tests.xml
```

#### **Option B: Run Individual Test Classes**
```bash
# Create Leave Tests
mvn test -Dtest=CreateLeaveTest

# Update Leave Tests  
mvn test -Dtest=UpdateLeaveTest

# Delete Leave Tests
mvn test -Dtest=DeleteLeaveTest

# Complete CRUD Tests
mvn test -Dtest=LeaveCRUDTest
```

#### **Option C: Run Specific Test Methods**
```bash
mvn test -Dtest=CreateLeaveTest#testCreateSickLeave
```

## 🧪 **Test Cases Overview**

### **1. Create Leave Tests** (`CreateLeaveTest.java`)
- ✅ Create Sick Leave
- ✅ Create Earned Leave  
- ✅ Create Casual Leave
- ✅ Create Comp Off Leave
- ✅ Verify Table Structure

### **2. Update Leave Tests** (`UpdateLeaveTest.java`)
- ✅ Update Leave Type
- ✅ Update Leave Dates
- ✅ Update Leave Reason
- ✅ Update Leave Type and Dates

### **3. Delete Leave Tests** (`DeleteLeaveTest.java`)
- ✅ Delete Single Day Leave
- ✅ Delete Multiple Day Leave
- ✅ Delete Different Leave Types
- ✅ Verify Table State After Deletion
- ✅ Delete Leave Actions Column

### **4. Complete CRUD Tests** (`LeaveCRUDTest.java`)
- ✅ Complete Leave CRUD Cycle
- ✅ CRUD with Different Leave Types
- ✅ CRUD with Multiple Day Leaves
- ✅ Table Structure During CRUD

### **5. Navigation Tests** (`NavigationTest.java`)
- ✅ Basic Navigation Flow
- ✅ Page Elements Presence

## 🔍 **Application URLs & Navigation**

### **Login Flow**
1. **Login Page**: `https://employeegalaxy.com/login/`
2. **Company Feed**: `https://employeegalaxy.com/employee/company-feed/`
3. **Leave List**: `https://employeegalaxy.com/employee/leaveList`
4. **Apply Leave**: `https://employeegalaxy.com/employee/applyLeave`

### **Navigation Steps**
1. **Login** → Enter credentials and submit
2. **Redirect** → Wait for company feed page
3. **Sidebar** → Click menu icon → Click "Leaves"
4. **Leave List** → View existing leaves in table
5. **Add Button** → Click "+" button to create new leave
6. **Apply Form** → Fill dates, select type, add reason, submit

## 📊 **Table Structure Verification**

The framework verifies the following table columns:
- ✅ Start Date
- ✅ End Date  
- ✅ No. of Days
- ✅ Leave Type
- ✅ Status
- ✅ Reason
- ✅ Actions (Edit/Delete buttons)

## 🎨 **Leave Types Supported**

- **Sick**: Medical and health-related leaves
- **EarnedLeave**: Vacation and personal time off
- **Casual**: Short-term personal leaves
- **CompOff**: Compensation for extra work hours

## 🔧 **Key Features**

### **Robust Element Handling**
- Handles read-only date fields gracefully
- Dynamic element finding to avoid stale references
- Comprehensive error handling and logging

### **Smart Date Management**
- Generates unique future dates for each test
- Prevents test data conflicts
- Supports single and multiple day leaves

### **Comprehensive Verification**
- Verifies leave creation in table
- Checks table structure consistency
- Validates leave count changes
- Confirms deletion success

### **Flexible Navigation**
- Sidebar menu navigation
- Direct URL navigation
- Add button navigation
- Automatic page load waiting

## 🚨 **Error Handling**

The framework includes:
- **Try-catch blocks** for all operations
- **Detailed logging** for debugging
- **Graceful fallbacks** for element interactions
- **Comprehensive error messages**

## 📝 **Test Execution Flow**

### **Create Leave Flow**
```
Login → Company Feed → Sidebar → Leaves → Add Button → Apply Form → Submit → Verify in Table
```

### **Update Leave Flow**
```
Login → Company Feed → Sidebar → Leaves → Find Leave → Edit Button → Update Form → Submit → Verify Update
```

### **Delete Leave Flow**
```
Login → Company Feed → Sidebar → Leaves → Find Leave → Delete Button → Confirm → Verify Deletion
```

## 🎯 **Best Practices Implemented**

1. **Page Object Model**: Separates UI elements from test logic
2. **Explicit Waits**: Ensures elements are ready before interaction
3. **Dynamic Data**: Generates unique test data for each run
4. **Comprehensive Assertions**: Verifies all aspects of operations
5. **Clean Test Structure**: Each test method focuses on one operation
6. **Detailed Logging**: Step-by-step execution tracking

## 🐛 **Troubleshooting**

### **Common Issues**

1. **Element Not Found**
   - Check if page is fully loaded
   - Verify element locators are correct
   - Use DebugPageElementsTest to inspect elements

2. **Navigation Failures**
   - Ensure login credentials are correct
   - Check if sidebar menu is accessible
   - Verify URLs are correct

3. **Date Field Issues**
   - Fields are read-only, use click → type → tab approach
   - Ensure date format is MM/dd/yyyy

### **Debug Tools**

- **DebugPageElementsTest**: Inspects all page elements
- **Console Logging**: Detailed step-by-step execution
- **Element Verification**: Checks element presence and state

## 📈 **Performance Features**

- **Parallel Execution**: Tests can run in parallel
- **Efficient Waits**: Uses explicit waits instead of fixed delays
- **Resource Management**: Proper WebDriver cleanup
- **Optimized Locators**: Uses most reliable element selectors

## 🔮 **Future Enhancements**

- [ ] Data-driven testing with Excel/CSV
- [ ] Parallel test execution
- [ ] Cross-browser testing
- [ ] API testing integration
- [ ] Performance testing
- [ ] Mobile testing support

## 📞 **Support**

For issues or questions:
1. Check console output for detailed error messages
2. Review element locators in LeavePage.java
3. Run DebugPageElementsTest to inspect page elements
4. Verify application URLs and navigation flow

## 📄 **License**

This framework is created for Leave Management System automation testing.

---

**🎉 Happy Testing! 🎉**
