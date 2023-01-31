$(function() {
    $("#side-content li").click(function(e) {
      e.preventDefault();
      $("#side-content li").removeClass("active");
      $(this).addClass("active");
    });
});

function hideAll() {
    $("#members-form").addClass('sidebar-option-selected-none');
    $("#dashboard-form").addClass('sidebar-option-selected-none');
    $("#events-form").addClass('sidebar-option-selected-none');
}

function usersTab() {
    hideAll()
    $("#members-form").removeClass('sidebar-option-selected-none');
}

function postsTab() {
    hideAll()
    $("#events-form").removeClass('sidebar-option-selected-none');
}

function chatTab() {
    hideAll()

}

function dashboardTab() {
    hideAll()
    $("#dashboard-form").removeClass('sidebar-option-selected-none');
}

$(function () {
    var frm = $('#add-user-to-group');
    frm.submit(function (ev) {
        $.ajax({
            type: frm.attr('method'),
            url: '/groups/add_user_to_group/',
            data: frm.serialize(),
            success: function (data) {
                window.location.reload();

            }
        });
    });
});

function addEvent(group_id) {
    var frm = $('#add-event');
    frm.submit(function (ev) {
        $.ajax({
            type: frm.attr('method'),
            url: `/groups/group/${group_id}/events/add/`,
            data: frm.serialize(),
            success: function (data) {
                window.location.reload();
            }
        });
    });
}

$(function () {

});