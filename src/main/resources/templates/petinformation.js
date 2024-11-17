function openEditModal() {
    document.getElementById('editModal').style.display = 'flex';
}

function openAddModal() {
    document.getElementById('addModal').style.display = 'flex';
}

function saveEdit() {
    const name = document.getElementById('editName').value;
    const gender = document.getElementById('editGender').value;
    const age = document.getElementById('editAge').value;
    const breed = document.getElementById('editBreed').value;
    const weight = document.getElementById('editWeight').value;
    const color = document.getElementById('editColor').value;

    document.getElementById('petName').innerText = `ชื่อ: ${name}`;
    document.getElementById('petGender').innerText = `เพศ: ${gender}`;
    document.getElementById('petAge').innerText = `อายุ: ${age}`;
    document.getElementById('petBreed').innerText = `พันธุ์: ${breed}`;
    document.getElementById('petWeight').innerText = `น้ำหนัก: ${weight}`;
    document.getElementById('petColor').innerText = `สีขน: ${color}`;

    document.getElementById('editModal').style.display = 'none';
}

function addHistory() {
    const date = document.getElementById('historyDate').value;
    const description = document.getElementById('historyDescription').value;
    const medicine = document.getElementById('medicineName').value;
    const price = document.getElementById('medicinePrice').value;
    const appointment = document.getElementById('appointmentDate').value;

    const table = document.getElementById('historyTable').getElementsByTagName('tbody')[0];
    const newRow = table.insertRow();
    newRow.innerHTML = `
        <td>${date}</td>
        <td>${description}</td>
        <td>${medicine}</td>
        <td>${price}</td>
        <td>${appointment}</td>
    `;

    document.getElementById('addModal').style.display = 'none';
}

window.onclick = function(event) {
    const editModal = document.getElementById('editModal');
    const addModal = document.getElementById('addModal');
    if (event.target == editModal) editModal.style.display = 'none';
    if (event.target == addModal) addModal.style.display = 'none';
};
