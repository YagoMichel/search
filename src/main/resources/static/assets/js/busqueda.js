$(document).ready(function() {
  const $searchInput = $('#search-input');
  const $suggestionsContainer = $('#suggestions-container');

  $searchInput.on('input', function() {
    const query = $(this).val().trim();

    if (query.length === 0) {
      $suggestionsContainer.addClass('hidden').empty();
      return;
    }

    $.ajax({
      url: '/api/search/suggestions',
      method: 'GET',
      data: { query: query },
      dataType: 'json',
      success: function(jobs) {
        console.log('Datos recibidos:', jobs); // Para depuración

        $suggestionsContainer.empty();

        if (jobs && jobs.length > 0) {
          jobs.forEach(function(job) {
            const $suggestionItem = $('<div>')
                .addClass('px-4 py-2 hover:bg-gray-100 cursor-pointer text-gray-800')
                .text(job.nombre)
                .data('id', job.id)
                .click(function() {
                  $searchInput.val(job.nombre);
                  $suggestionsContainer.addClass('hidden');
                });

            $suggestionsContainer.append($suggestionItem);
          });
          $suggestionsContainer.removeClass('hidden');
        } else {
          $suggestionsContainer.addClass('hidden');
        }
      },
      error: function(xhr, status, error) {
        console.error('Error:', error);
        $suggestionsContainer.addClass('hidden');
      }
    });
  });

  $(document).on('click', function(e) {
    if (!$(e.target).closest('.fromGroup').length) {
      $suggestionsContainer.addClass('hidden');
    }
  });
});