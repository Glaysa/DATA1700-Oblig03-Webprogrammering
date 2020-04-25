/** Display text */
let display = $("#display-container");

$("#buyButton").click(function () {
    /** Input Fields */
    let fname = $("#fname").val();
    let lname = $("#lname").val();
    let email = $("#email").val();
    let film = $("#film").val();
    let tlf = $("#tlf").val();
    let qty = $("#qty").val();

    /** Error Labels */
    let err_fname = $("#err-fname");
    let err_lname = $("#err-lname");
    let err_email = $("#err-email");
    let err_tlf = $("#err-tlf");
    let err_qty = $("#err-qty");

    /** Validate Input values */
    if(!fname){err_fname.html("Ugyldig Input"); } else {err_fname.html(""); }
    if(!lname){err_lname.html("Ugyldig Input"); } else {err_lname.html(""); }
    if(!email){err_email.html("Ugyldig Input"); } else {err_email.html(""); }
    if(!tlf){err_tlf.html("Ugyldig Input"); } else {err_tlf.html(""); }
    if(!qty){err_qty.html("Ugyldig Input"); } else {err_qty.html(""); }

    let valid = fname && lname && email && tlf && qty;

    if(valid){
        const customer = {
            fname: fname,
            lname: lname,
            email: email,
            film: film,
            tlf: Number(tlf),
            qty: Number(qty) };

        /** Reset form */
        $("#form").trigger("reset");

        /** Show all tickets */
        $.post("/save", customer, function () {
            getData();
        });
    }

});

/** Henter listen av kundene */
function getData() {
    $.get("/getData", function (data) {
        reformatData(data);
    })
}

/** Viser alle kundene i en tabell */
function reformatData(customerList){
    let table = "<table class='table table-striped'>" +
                "<tr><th>Fornavn</th>" +
                "<th>Etternavn</th>" +
                "<th>Email</th>" +
                "<th>Film</th>" +
                "<th>Tlf</th>" +
                "<th>QTY</th></tr>";
    for(let c of customerList){
        table += "<tr><td>"+c.fname+"</td>" +
                "<td>"+c.lname+"</td>" +
                "<td>"+c.email+"</td>" +
                "<td>"+c.film+"</td>" +
                "<td>"+c.tlf+"</td>" +
                "<td>"+c.qty+"</td></tr>"; }

    table += "</table>";
    display.html(table);
}

/** Sletter alle billetter */
$("#delButton").click(function () {
    $.post("/del", function (data) {
        display.html(data);
    });
});
