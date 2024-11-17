function addRow() {
    var table = document.getElementById('appointments-table');
    var newRow = table.insertRow(table.rows.length); // เพิ่มแถวที่ท้ายสุด
    var phone = prompt("กรอกเบอร์โทรศัพท์");
    var owner = prompt("กรอกชื่อเจ้าของสัตว์");
    var petName = prompt("กรอกชื่อสัตว์เลี้ยง");
    var appointment = prompt("กรอกวันที่และเวลานัดหมาย");


    newRow.innerHTML = `
        <td>${phone}</td>
        <td>${owner}</td>
        <td>${petName}</td>
        <td>${appointment}</td>
        <td class="edit-column"><span class="edit-icon" onclick="editRow(this)">✎️</span></td>
    `;
}


function deleteRow() {
    var table = document.getElementById('appointments-table');
    var rowCount = table.rows.length;


    if (rowCount > 1) {
        table.deleteRow(1); 
    } else {
        alert("ไม่สามารถลบได้ เนื่องจากไม่มีแถวให้ลบ");
    }
}


function editRow(icon) {
    var row = icon.closest("tr");  // หาแถวที่เป็น parent ของไอคอน
    var phone = row.cells[0].innerText;
    var owner = row.cells[1].innerText;
    var petName = row.cells[2].innerText;
    var appointment = row.cells[3].innerText;

    phone = prompt("กรอกเบอร์โทรศัพท์", phone);
    owner = prompt("กรอกชื่อเจ้าของสัตว์", owner);
    petName = prompt("กรอกชื่อสัตว์เลี้ยง", petName);
    appointment = prompt("กรอกวันที่และเวลานัดหมาย", appointment);

    row.cells[0].innerText = phone;
    row.cells[1].innerText = owner;
    row.cells[2].innerText = petName;
    row.cells[3].innerText = appointment;
}