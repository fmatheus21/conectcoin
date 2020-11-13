$(document).ready(function () {
    var SPMaskBehavior = function (val) {
        return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
    },
            spOptions = {
                onKeyPress: function (val, e, field, options) {
                    field.mask(SPMaskBehavior.apply({}, arguments), options);
                }
            };

    $('.phone-mask').mask(SPMaskBehavior, spOptions);
    $('.date-mask').mask('00/00/0000', {clearIfNotMatch: true, selectOnFocus: true});
    $('.cpf-mask').mask('000.000.000-00', {reverse: true, clearIfNotMatch: true, selectOnFocus: true});
    $('.cep-mask').mask('00000-000', {clearIfNotMatch: true, selectOnFocus: true});
    $('.creditCardDate-mask').mask('00/00', {clearIfNotMatch: true, selectOnFocus: true});
    $('.money-mask').mask("#.##0,00", {clearIfNotMatch: true, reverse: true});
    $('.percent-mask').mask("##0.0", {clearIfNotMatch: true, reverse: true});
    $(".username-mask").mask("000000000000000000000000", {"translation": {0: {pattern: /[A-Za-z0-9]/}}});
});