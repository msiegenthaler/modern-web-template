describe('Directive AppVersion', () ->
  beforeEach(angular.module('myApp'))

  beforeEach(inject(($rootScope, $compile) ->

    element = angular.element("""
      <div><span app-version></span></div>
    """)
    scope = $rootScope
    $compile(element, scope)
    scope.$digest()
  ))

  it('should output the version', () ->
    span = element.find('span')
    expect(span.text).toBe("1.2.3")
  )
)