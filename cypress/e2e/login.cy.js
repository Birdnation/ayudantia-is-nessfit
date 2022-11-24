describe('Login', () => {
  it('ingresa al login', () => {
    cy.visit('/')
  })
  
  it('incio erroneo', () => {
	cy.get('#rut').type("9999")
	cy.get('#contrasena').type('9999')
	cy.get('#btnSubmit').click()
	cy.visit('/')
	.should('have.text', 'Walk the dog')
})
})