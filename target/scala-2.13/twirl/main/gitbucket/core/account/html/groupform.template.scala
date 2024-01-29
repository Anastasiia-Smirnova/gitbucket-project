
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object groupform extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Option[gitbucket.core.model.Account],List[gitbucket.core.model.GroupMember],Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: Option[gitbucket.core.model.Account],
  members: List[gitbucket.core.model.GroupMember],
  admin: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.1*/("""<div class="row">
  <div class="col-md-5">
    <fieldset class="form-group">
      <label for="groupName" class="strong">Group name</label>
      <div>
        <span id="error-groupName" class="error"></span>
      </div>
      <input type="text" name="groupName" id="groupName" class="form-control" value=""""),_display_(/*11.87*/account/*11.94*/.map(_.userName)),format.raw/*11.110*/("""""""),_display_(if(account.isDefined)/*11.133*/{_display_(Seq[Any](format.raw/*11.134*/(""" """),format.raw/*11.135*/("""readonly""")))} else {null} ),format.raw/*11.144*/("""/>
      """),_display_(if(account.isDefined && admin)/*12.38*/{_display_(Seq[Any](format.raw/*12.39*/("""
        """),format.raw/*13.9*/("""<label for="removed">
          <input type="checkbox" name="removed" id="removed" value="true" """),_display_(if(account.get.isRemoved)/*14.101*/{_display_(Seq[Any](format.raw/*14.102*/("""checked""")))} else {null} ),format.raw/*14.110*/("""/>
          Disable
        </label>
      """)))} else {null} ),format.raw/*17.8*/("""
    """),format.raw/*18.5*/("""</fieldset>
    <fieldset class="form-group">
      <label class="strong" for="url">URL (Optional)</label>
      <div>
        <span id="error-url" class="error"></span>
      </div>
      <input type="text" name="url" id="url" class="form-control" value=""""),_display_(/*24.75*/account/*24.82*/.map(_.url)),format.raw/*24.93*/(""""/>
    </fieldset>
    <fieldset class="form-group">
      <label for="description" class="strong">Description (Optional)</label>
      <div>
        <textarea name="description" id="description" class="form-control">"""),_display_(/*29.77*/account/*29.84*/.map(_.description)),format.raw/*29.103*/("""</textarea>
      </div>
    </fieldset>
    <fieldset class="form-group">
      <label for="avatar" class="strong">Image (Optional)</label>
      """),_display_(/*34.8*/gitbucket/*34.17*/.core.helper.html.uploadavatar(account)),format.raw/*34.56*/("""
    """),format.raw/*35.5*/("""</fieldset>
  </div>
  <div class="col-md-7">
    <fieldset class="form-group">
      <label class="strong">Members</label>
      <ul id="member-list" class="collaborator">
      </ul>
      """),_display_(/*42.8*/gitbucket/*42.17*/.core.helper.html.account("memberName", 200, true, false)),format.raw/*42.74*/("""
      """),format.raw/*43.7*/("""<input type="button" class="btn btn-default" value="Add" id="addMember"/>
      <input type="hidden" id="members" name="members" value=""""),_display_(/*44.64*/members/*44.71*/.map(member => member.userName + ":" + member.isManager).mkString(",")),format.raw/*44.141*/(""""/>
      <div>
        <span class="error" id="error-members"></span>
      </div>
    </fieldset>
  </div>
</div>
<script>
$(function()"""),format.raw/*52.13*/("""{"""),format.raw/*52.14*/("""
  """),format.raw/*53.3*/("""$('input[type=submit]').click(function()"""),format.raw/*53.43*/("""{"""),format.raw/*53.44*/("""
    """),format.raw/*54.5*/("""updateMembers();
  """),format.raw/*55.3*/("""}"""),format.raw/*55.4*/(""");

  $('#addMember').click(function()"""),format.raw/*57.35*/("""{"""),format.raw/*57.36*/("""
    """),format.raw/*58.5*/("""$('#error-members').text('');
    var userName = $('#memberName').val();

    // check empty
    if($.trim(userName) == '')"""),format.raw/*62.31*/("""{"""),format.raw/*62.32*/("""
      """),format.raw/*63.7*/("""return false;
    """),format.raw/*64.5*/("""}"""),format.raw/*64.6*/("""

    """),format.raw/*66.5*/("""// check duplication
    var exists = $('#member-list li').filter(function()"""),format.raw/*67.56*/("""{"""),format.raw/*67.57*/("""
      """),format.raw/*68.7*/("""return $(this).data('name') == userName;
    """),format.raw/*69.5*/("""}"""),format.raw/*69.6*/(""").length > 0;
    if(exists)"""),format.raw/*70.15*/("""{"""),format.raw/*70.16*/("""
      """),format.raw/*71.7*/("""$('#error-members').text('User has been already added.');
      return false;
    """),format.raw/*73.5*/("""}"""),format.raw/*73.6*/("""

    """),format.raw/*75.5*/("""// check existence
    $.post('"""),_display_(/*76.14*/context/*76.21*/.path),format.raw/*76.26*/("""/_user/existence', """),format.raw/*76.45*/("""{"""),format.raw/*76.46*/(""" """),format.raw/*76.47*/("""'userName': userName """),format.raw/*76.68*/("""}"""),format.raw/*76.69*/(""",
      function(data, status)"""),format.raw/*77.29*/("""{"""),format.raw/*77.30*/("""
        """),format.raw/*78.9*/("""if(data == 'user')"""),format.raw/*78.27*/("""{"""),format.raw/*78.28*/("""
          """),format.raw/*79.11*/("""addMemberHTML(userName, false);
          $('#memberName').val('');
        """),format.raw/*81.9*/("""}"""),format.raw/*81.10*/(""" """),format.raw/*81.11*/("""else """),format.raw/*81.16*/("""{"""),format.raw/*81.17*/("""
          """),format.raw/*82.11*/("""$('#error-members').text('User does not exist.');
        """),format.raw/*83.9*/("""}"""),format.raw/*83.10*/("""
      """),format.raw/*84.7*/("""}"""),format.raw/*84.8*/(""");
  """),format.raw/*85.3*/("""}"""),format.raw/*85.4*/(""");

  $(document).on('click', '.remove', function()"""),format.raw/*87.48*/("""{"""),format.raw/*87.49*/("""
    """),format.raw/*88.5*/("""$(this).parent().remove();
  """),format.raw/*89.3*/("""}"""),format.raw/*89.4*/(""");

  // Don't submit form by ENTER key
  $('#memberName').keypress(function(e)"""),format.raw/*92.40*/("""{"""),format.raw/*92.41*/("""
    """),format.raw/*93.5*/("""return !(e.keyCode == 13);
  """),format.raw/*94.3*/("""}"""),format.raw/*94.4*/(""");

  $('#delete').click(function()"""),format.raw/*96.32*/("""{"""),format.raw/*96.33*/("""
    """),format.raw/*97.5*/("""return confirm('Once you delete this group, there is no going back.\nAre you sure?');
  """),format.raw/*98.3*/("""}"""),format.raw/*98.4*/(""");

  """),_display_(/*100.4*/members/*100.11*/.map/*100.15*/ { member =>_display_(Seq[Any](format.raw/*100.27*/("""
    """),format.raw/*101.5*/("""addMemberHTML('"""),_display_(/*101.21*/member/*101.27*/.userName),format.raw/*101.36*/("""', """),_display_(/*101.40*/member/*101.46*/.isManager),format.raw/*101.56*/(""");
  """)))}),format.raw/*102.4*/("""

  """),format.raw/*104.3*/("""function addMemberHTML(userName, isManager)"""),format.raw/*104.46*/("""{"""),format.raw/*104.47*/("""
    """),format.raw/*105.5*/("""var memberButton = $('<label class="btn btn-default btn-mini"><input type="radio" value="false" name="' + userName + '">Member</label>');
    if(!isManager)"""),format.raw/*106.19*/("""{"""),format.raw/*106.20*/("""
      """),format.raw/*107.7*/("""memberButton.addClass('active');
    """),format.raw/*108.5*/("""}"""),format.raw/*108.6*/("""
    """),format.raw/*109.5*/("""var managerButton = $('<label class="btn btn-default btn-mini"><input type="radio" value="true" name="' + userName + '">Manager</label>');
    if(isManager)"""),format.raw/*110.18*/("""{"""),format.raw/*110.19*/("""
      """),format.raw/*111.7*/("""managerButton.addClass('active');
    """),format.raw/*112.5*/("""}"""),format.raw/*112.6*/("""

    """),format.raw/*114.5*/("""$('#member-list').append($('<li>')
      .data('name', userName)
      .append($('<div class="btn-group is_manager" data-toggle="buttons">')
        .append(memberButton)
        .append(managerButton))
      .append(' ')
      .append($('<a>').attr('href', '"""),_display_(/*120.39*/context/*120.46*/.path),format.raw/*120.51*/("""/' + userName).text(userName))
      .append(' ')
      .append($('<a href="#" class="remove pull-right"><span class="octicon octicon-x" aria-label="Remove"></span></a>')));
  """),format.raw/*123.3*/("""}"""),format.raw/*123.4*/("""

  """),format.raw/*125.3*/("""function updateMembers()"""),format.raw/*125.27*/("""{"""),format.raw/*125.28*/("""
    """),format.raw/*126.5*/("""var members = $('#member-list li').map(function(i, e)"""),format.raw/*126.58*/("""{"""),format.raw/*126.59*/("""
      """),format.raw/*127.7*/("""var userName = $(e).data('name');
      return userName + ':' + $(e).find('label.active input[type=radio]').attr('value');
    """),format.raw/*129.5*/("""}"""),format.raw/*129.6*/(""").get().join(',');
    $('#members').val(members);
  """),format.raw/*131.3*/("""}"""),format.raw/*131.4*/("""
"""),format.raw/*132.1*/("""}"""),format.raw/*132.2*/(""");
</script>
"""))
      }
    }
  }

  def render(account:Option[gitbucket.core.model.Account],members:List[gitbucket.core.model.GroupMember],admin:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,members,admin)(context)

  def f:((Option[gitbucket.core.model.Account],List[gitbucket.core.model.GroupMember],Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,members,admin) => (context) => apply(account,members,admin)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/groupform.scala.html
                  HASH: 4070e8d6eca6c5c5bfca11802cdab40f8b939747
                  MATRIX: 698->1|961->171|1296->479|1312->486|1350->502|1401->525|1441->526|1471->527|1525->536|1592->576|1631->577|1667->586|1817->708|1857->709|1910->717|1998->762|2030->767|2314->1024|2330->1031|2362->1042|2608->1261|2624->1268|2665->1287|2839->1435|2857->1444|2917->1483|2949->1488|3167->1680|3185->1689|3263->1746|3297->1753|3461->1890|3477->1897|3569->1967|3734->2104|3763->2105|3793->2108|3861->2148|3890->2149|3922->2154|3968->2173|3996->2174|4062->2212|4091->2213|4123->2218|4274->2341|4303->2342|4337->2349|4382->2367|4410->2368|4443->2374|4547->2450|4576->2451|4610->2458|4682->2503|4710->2504|4766->2532|4795->2533|4829->2540|4938->2622|4966->2623|4999->2629|5058->2661|5074->2668|5100->2673|5147->2692|5176->2693|5205->2694|5254->2715|5283->2716|5341->2746|5370->2747|5406->2756|5452->2774|5481->2775|5520->2786|5623->2862|5652->2863|5681->2864|5714->2869|5743->2870|5782->2881|5867->2939|5896->2940|5930->2947|5958->2948|5990->2953|6018->2954|6097->3005|6126->3006|6158->3011|6214->3040|6242->3041|6349->3120|6378->3121|6410->3126|6466->3155|6494->3156|6557->3191|6586->3192|6618->3197|6733->3285|6761->3286|6795->3293|6812->3300|6826->3304|6877->3316|6910->3321|6954->3337|6970->3343|7001->3352|7033->3356|7049->3362|7081->3372|7118->3378|7150->3382|7222->3425|7252->3426|7285->3431|7470->3587|7500->3588|7535->3595|7600->3632|7629->3633|7662->3638|7847->3794|7877->3795|7912->3802|7978->3840|8007->3841|8041->3847|8329->4107|8346->4114|8373->4119|8577->4295|8606->4296|8638->4300|8691->4324|8721->4325|8754->4330|8836->4383|8866->4384|8901->4391|9056->4518|9085->4519|9166->4572|9195->4573|9224->4574|9253->4575
                  LINES: 14->1|21->4|28->11|28->11|28->11|28->11|28->11|28->11|28->11|29->12|29->12|30->13|31->14|31->14|31->14|34->17|35->18|41->24|41->24|41->24|46->29|46->29|46->29|51->34|51->34|51->34|52->35|59->42|59->42|59->42|60->43|61->44|61->44|61->44|69->52|69->52|70->53|70->53|70->53|71->54|72->55|72->55|74->57|74->57|75->58|79->62|79->62|80->63|81->64|81->64|83->66|84->67|84->67|85->68|86->69|86->69|87->70|87->70|88->71|90->73|90->73|92->75|93->76|93->76|93->76|93->76|93->76|93->76|93->76|93->76|94->77|94->77|95->78|95->78|95->78|96->79|98->81|98->81|98->81|98->81|98->81|99->82|100->83|100->83|101->84|101->84|102->85|102->85|104->87|104->87|105->88|106->89|106->89|109->92|109->92|110->93|111->94|111->94|113->96|113->96|114->97|115->98|115->98|117->100|117->100|117->100|117->100|118->101|118->101|118->101|118->101|118->101|118->101|118->101|119->102|121->104|121->104|121->104|122->105|123->106|123->106|124->107|125->108|125->108|126->109|127->110|127->110|128->111|129->112|129->112|131->114|137->120|137->120|137->120|140->123|140->123|142->125|142->125|142->125|143->126|143->126|143->126|144->127|146->129|146->129|148->131|148->131|149->132|149->132
                  -- GENERATED --
              */
          