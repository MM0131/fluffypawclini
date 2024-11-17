function addPet() {
    alert("เพิ่มสัตว์เลี้ยงใหม่");
    // เพิ่มโค้ดสำหรับการเพิ่มกล่องสัตว์เลี้ยงที่นี่
}

function deletePet(button) {
    if (confirm("คุณต้องการลบสัตว์เลี้ยงนี้หรือไม่?")) {
        const petBox = button.parentElement;
        petBox.remove();
    }
}
